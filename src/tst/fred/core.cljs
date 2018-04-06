(ns tst.fred.core
  (:require
    [cljs.test :refer-macros [deftest is async]]
    [dno] ))

(deftest t-will-succeed (is (=  5 (+ 2 3))))
; (deftest t-will-fail (is (= 95 (+ 2 3))))

(deftest t-alan
  (println "globalObject:  " js/globalObject)
  (let [result-7 (-> js/globalObject .-b (+ 5))
        greeting (-> (js/makeFriendly) .-message)]
    (println "(-> % .-b (+ 5) =>" result-7)
    (println "(-> (js/makeFriendly) .-message) =>")
    (is (= 7 result-7))
    (is (= "Howdy!" greeting)))

)

