(ns foo-test
  (:require [clojure.test :refer :all]
            [foo :as f]))

(deftest foo-test
  (is (= "hello" (f/bar))))
  
