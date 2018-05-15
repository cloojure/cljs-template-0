(ns flintstones.core
  (:require
    [reagent.core :as r]
    [clojure.string :as str] ))

(enable-console-print!)
(println
"This text is printed from src/flintstones/core.cljs.
Go ahead and edit it and see reloading in action. Again, or not.")
(println " Hello World! " )

(def states
  ["Alabama" "Alaska" "Arizona" "Arkansas" "California"
   "Colorado" "Connecticut" "Delaware" "Florida" "Georgia" "Hawaii"
   "Idaho" "Illinois" "Indiana" "Iowa" "Kansas" "Kentucky" "Louisiana"
   "Maine" "Maryland" "Massachusetts" "Michigan" "Minnesota"
   "Mississippi" "Missouri" "Montana" "Nebraska" "Nevada" "New Hampshire"
   "New Jersey" "New Mexico" "New York" "North Carolina" "North Dakota"
   "Ohio" "Oklahoma" "Oregon" "Pennsylvania" "Rhode Island"
   "South Carolina" "South Dakota" "Tennessee" "Texas" "Utah" "Vermont"
   "Virginia" "Washington" "West Virginia" "Wisconsin" "Wyoming"])

(defn matcher [strs]
  (fn [text callback]
    (->> strs
         (filter #(str/includes? % text))
         (clj->js)
         (callback))))

(defn typeahead-mounted [this]
  (.typeahead (js/$ (r/dom-node this))
              (clj->js {:hint true
                        :highlight true
                        :minLength 1})
              (clj->js {:name "states"
                        :source (matcher states)})))

(def typeahead-value (r/atom nil))

(defn render-typeahead []
  [:input.typeahead
   {:type :text
    :on-select #(reset! typeahead-value (-> % .-target .-value))
    :placeholder "Programming Languages"}])

(defn typeahead []
  (r/create-class
    {:component-did-mount typeahead-mounted
     :reagent-render render-typeahead}))

(defn home []
  [:div.ui-widget
   (when-let [language @typeahead-value]
     [:label "selected: " language])
   [typeahead]])

(home)

; define your app data so that it doesn't get over-written on reload
(defonce app-state (atom {:text "Hello world!"}))

(defn on-js-reload []
  ; optionally touch your app-state to force rerendering depending on your application
  ; (swap! app-state update-in [:__figwheel_counter] inc)
  (r/render [simple-example]
            (js/document.getElementById "tgt-div"))
)
