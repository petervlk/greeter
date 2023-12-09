(ns greeter.core
  (:gen-class))

(defn greet
  "Callable entry point to the application."
  [name]
  (format "Hello, %s!" (or name "World")) )

(defn -main
  [& args]
  (println (greet (first args))))
