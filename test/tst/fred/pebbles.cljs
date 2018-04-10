(ns tst.fred.pebbles
  (:require
    [cljs.test :refer-macros [deftest is async]] ))

(deftest t-count (is (= 2 (+ 1 1))))

;(deftest t-pebbles
;  (println "js/pebblesInfo:  " js/pebblesInfo)
;  (let [pebbles (js/makePebbles)]
;    (println "pebbles =>" pebbles)
;    (is (= (.-desc pebbles) "cute baby"))
;    (is (= (.says pebbles "Fred") "GaGa BoBo..."))))
