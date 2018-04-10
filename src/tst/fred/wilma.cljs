(ns tst.fred.wilma
  (:require
    [cljs.test :refer-macros [deftest is async]]
    [wilmaPhony]
  ))

(deftest succeeder (is (= 3 (+ 2 1))))

(deftest t-wilma
  (println "globalObject:  " wilmaPhony/stats)
  (is (not= wilmaPhony/stats
        wilmaPhony/stats2)) ; JS objs are not=
  (is (= (js->clj wilmaPhony/stats) ; must convert to clojure maps for value equality to work
         (js->clj wilmaPhony/stats2)))
  (let [wilma     (wilmaPhony/makeWilma) ]
    (println "wilma =>" wilma)
    (is (= (.-desc wilma) "patient housewife"))
    (is (= (.says wilma "Fred") "Hello, Fred"))))
