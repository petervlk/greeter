(ns user
  (:require
   [integrant.core :as ig]
   [integrant.repl :as ig-repl]
   [greeter.core :refer [config]]))

(ig-repl/set-prep!
  (fn []
    (ig/load-namespaces config)
    (ig/prep config)))

(defmethod ig/prep-key :greeter/handler [_ handler-config]
  (assoc handler-config :greetee "dev Dave"))

(comment
  (ig-repl/go)

  (ig-repl/halt)

  (ig-repl/reset)

  *e)
