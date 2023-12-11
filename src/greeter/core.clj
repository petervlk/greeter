(ns greeter.core
  (:require
   [clojure.java.io :as io]
   [integrant.core :as ig])
  (:gen-class))

(def config
  (-> (io/resource "config.edn")
      slurp
      ig/read-string))

(defn -main
  [& _args]
  (ig/load-namespaces config)
  (ig/init config))
