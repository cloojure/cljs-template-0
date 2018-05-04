(ns flintstones.core)

(enable-console-print!)
(println
"This text is printed from src/flintstones/core.cljs.
Go ahead and edit it and see reloading in action. Again, or not.")
(println "<<< replace this text >>> ")

(do                 ; like a "unit test" w/o the Doo framework
  (println "demo of `pebbles.js` access (flintstones.core):")
  (println "  js/pebblesInfo => " (pr-str js/pebblesInfo))
  (let [pebbles (js/makePebbles)]
    (println "  pebbles =>" (pr-str pebbles))
    (println "  (.says pebbles 'Fred'): => " (pr-str (.says pebbles "Fred")))
    (assert (= (.-desc pebbles) "cute baby"))
    (assert (= (.says pebbles "Fred") "GaGa BooBoo..."))))


; define your app data so that it doesn't get over-written on reload
(defonce app-state (atom {:text "Hello world!"}))


(defn on-js-reload []
  ; optionally touch your app-state to force rerendering depending on your application
  ; (swap! app-state update-in [:__figwheel_counter] inc)
)
