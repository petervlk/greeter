(ns greeter.core
  (:require
   [aero.core :as aero]
   [clojure.java.io :as io]
   [integrant.core :as ig])
  (:gen-class))

(defmethod aero/reader 'ig/ref [_ _ value]
  (ig/ref value))

(defmethod aero/reader 'ig/refset [_ _ value]
  (ig/refset value))

(defn load-config!
  ([]
   (-> (io/resource "config.edn")
       (aero/read-config))))

(defn load-namespaces [cfg]
  (ig/load-namespaces cfg)
  cfg)

(defn -main
  [& _args]
  (-> (load-config!)
      load-namespaces
      ig/init))
