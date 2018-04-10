(ns tst.fred.wilma
  (:require
    [cljs.test :refer-macros [deftest is async]]
    [wilmaphony]
  ))

(deftest succeeder (is (= 3 (+ 2 1))))

(deftest t-wilma
  (println "globalObject:  " wilmaphony/stats)
  (is (not= wilmaphony/stats
        wilmaphony/stats2)) ; JS objs are not=
  (is (= (js->clj wilmaphony/stats) ; must convert to clojure maps for value equality to work
         (js->clj wilmaphony/stats2)))
  (let [wilma     (wilmaphony/makeWilma) ]
    (println "wilma =>" wilma)
    (is (= (.-desc wilma) "patient housewife"))
    (is (= (.says wilma "Fred") "Hello, Fred"))))
