(ns tst.fred.pebbles
  (:require
    [cljs.test :refer-macros [deftest is async use-fixtures]]))
(use-fixtures :once
  {:before (fn [] (println "Beginning pebbles tests..."))
   :after  (fn [] (println "Finished pebbles tests..."))})

(deftest t-pebbles
  (is (= 2 (+ 1 1))) ; this works
  ; This must be commented-out, or it will throw an Error since `pebbles.js` is only
  ; included via the <script> tag in `index.html`. The Doo testing framework doesn't
  ; use `index.html`, so we cannot access items from `pebbles.js` in these tests.
  (comment
    (println "js/pebblesInfo:  " js/pebblesInfo))
  )
