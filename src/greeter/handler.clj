(ns greeter.handler
  (:require
   [integrant.core :as ig]))

(defn greet
  [greetee]
  (format "Hello, %s!" (or greetee "World")) )

(defn handler
  [greetee _req]
  {:status 200
   :body   (greet greetee)})

(defmethod ig/init-key :greeter/handler [_ {:keys [greetee]}]
  (partial #'handler greetee))
