(ns user
  (:require
   [integrant.core :as ig]
   [integrant.repl :as ig-repl]
   [greeter.core :refer [load-config! load-namespaces]]))

(ig-repl/set-prep!
  (fn []
    (-> (load-config!)
        load-namespaces
        ig/prep)))

(defmethod ig/prep-key :greeter/handler [_ handler-config]
  (update handler-config :greetee #(str "dev " %)))

(comment
  (ig-repl/go)

  (ig-repl/halt)

  (ig-repl/reset)

  *e)
