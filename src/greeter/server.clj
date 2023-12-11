(ns greeter.server
  (:require [ring.adapter.jetty :refer [run-jetty]]
            [integrant.core :as ig]))

(defmethod ig/init-key :greeter/server [_ {:keys [port handler]}]
  (run-jetty handler {:port port :join? false}))

(defmethod ig/halt-key! :greeter/server [_ jetty]
  (when jetty
    (.stop jetty)))
