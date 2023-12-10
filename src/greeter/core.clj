(ns greeter.core
  (:require [ring.adapter.jetty :refer [run-jetty]]
            [integrant.core :as ig])
  (:gen-class))

(def config
  {:greeter/server  {:port 9010 :handler (ig/ref :greeter/handler)}
   :greeter/handler {:greetee "Jack"}})

(defn greet
  [greetee]
  (format "Hello, %s!" (or greetee "World")) )

(defn handler
  [greetee _req]
  {:status 200
   :body   (greet greetee)})

(defmethod ig/init-key :greeter/handler [_ {:keys [greetee]}]
  (partial #'handler greetee))

(defmethod ig/init-key :greeter/server [_ {:keys [port handler]}]
  (run-jetty handler {:port port :join? false}))

(defmethod ig/halt-key! :greeter/server [_ jetty]
  (when jetty
    (.stop jetty)))

(defn -main
  [& _args]
  (ig/init config))
