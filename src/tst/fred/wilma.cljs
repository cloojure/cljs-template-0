(ns tst.fred.wilma
  (:require
    [cljs.test :refer-macros [deftest is async]]
    [flintstones.chars.wilma :as wlma]))

(deftest t-wilma
  (println "globalObject:  " wlma/stats)
  (let [wilma     (wlma/makeWilma) ]
    (println "wilma =>" wilma)
    (is (= (.-desc wilma) "patient housewife"))
    (is (= (.-says wilma "Fred") "Hello, Fred"))))

