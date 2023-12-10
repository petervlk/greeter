(ns greeter.core
  (:require [ring.adapter.jetty :refer [run-jetty]])
  (:gen-class))

(defn greet
  [name]
  (format "Hello, %s!" (or name "World")) )

(defn handler
  [_req]
  {:status 200
   :body   (greet "Jack")})

(defonce server (atom nil))

(defn server-start
  []
  (when-not @server
    (reset! server (run-jetty #'handler {:port 9010 :join? false}))))

(defn server-stop
  []
  (when @server
    (.stop @server)
    (reset! server nil)))

(defn server-restart
  []
  (server-stop)
  (server-start))

(comment
  (server-restart)

  *e)

(defn -main
  [& _args]
  (server-start))
