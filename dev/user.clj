(ns user
  (:require
   [integrant.repl :as ig-repl]
   [greeter.core :refer [config]]))

(ig-repl/set-prep!
  (fn [] config))

(comment
  (ig-repl/go)

  (ig-repl/halt)

  (ig-repl/reset)

  *e)
