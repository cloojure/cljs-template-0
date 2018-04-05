(ns fred.core
    (:require [dno]
              [appmeas] ))

(enable-console-print!)

(println
"This text is printed from src/fred/core.cljs.
Go ahead and edit it and see reloading in action. Again, or not.")

(println "globalObject:  " js/globalObject)
(println "(-> % .-b (+ 5) =>" (-> js/globalObject .-b (+ 5)))
(println "(-> (js/makeFriendly) .-message) =>" (-> (js/makeFriendly) .-message))
(println "(AppMeasurement.) =>" (js/AppMeasurement.))  ; need trailing `.` for constructor

; define your app data so that it doesn't get over-written on reload
(defonce app-state (atom {:text "Hello world!"}))


(defn on-js-reload []
  ; optionally touch your app-state to force rerendering depending on your application
  ; (swap! app-state update-in [:__figwheel_counter] inc)
)
