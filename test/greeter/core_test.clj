(ns greeter.core-test
  (:require [clojure.test :refer [deftest is testing]]
            [greeter.core :as sut]))

(deftest greet-test
  (testing "Given no name provided, then greet World"
    (is (= "Hello, World!" (sut/greet nil))))
  (testing "Given name, then use it in greeting"
    (is (= "Hello, Jack!" (sut/greet "Jack")))))
