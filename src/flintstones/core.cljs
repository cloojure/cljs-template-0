(ns flintstones.core
  (:require
    [oops.core :as oops]
    [reagent.core :as r]
    [reagent.format :as rf]
    [clojure.string :as str] ))

(enable-console-print!)
(println
"This text is printed from src/flintstones/core.cljs.
Go ahead and edit it and see reloading in action. Again, or not.")
(println " Hello World! " )

(def states-all
  ["Alabama" "Alaska" "Arizona" "Arkansas" "California"
   "Colorado" "Connecticut" "Delaware" "Florida" "Georgia" "Hawaii"
   "Idaho" "Illinois" "Indiana" "Iowa" "Kansas" "Kentucky" "Louisiana"
   "Maine" "Maryland" "Massachusetts" "Michigan" "Minnesota"
   "Mississippi" "Missouri" "Montana" "Nebraska" "Nevada" "New Hampshire"
   "New Jersey" "New Mexico" "New York" "North Carolina" "North Dakota"
   "Ohio" "Oklahoma" "Oregon" "Pennsylvania" "Rhode Island"
   "South Carolina" "South Dakota" "Tennessee" "Texas" "Utah" "Vermont"
   "Virginia" "Washington" "West Virginia" "Wisconsin" "Wyoming"
   ])


(def states-curr (r/atom []))

(defn curr-states-list []
  [:div {:id :states-keep}
   (for [state (take 10 @states-curr)]
     ^{:key state} [:div {:on-click ; #(println "clicked:" state)
                          #(let [elem (js/document.getElementById "myInput")]
                             (oops/oset! elem "value" state)
                             (reset! states-curr []) ) }
                    state ])] )

(defn simple-component []
  [:div
   [:p "I am a component!"]
   [:p.someclass
    "I have " [:strong "bold"]
    [:span {:style {:color "red"}} " and red"] " text."]

   [:form {:autoComplete "off" }
    [:div {:class     "autocomplete" :style {:width "300px"}
           :on-change (fn [arg]
                        (println)
                        (let [curr-text   (-> arg .-target .-value)
                              repat       (re-pattern (str "(?i)\\b\\w*" curr-text "\\w*\\b"))
                              keep?       (fn [state] (re-find repat state))
                              states-keep (if (pos? (count curr-text))
                                            (vec (filter keep? states-all))
                                            []) ]
                          (println "states-keep = " states-keep)
                          (reset! states-curr states-keep))) }

     [:input {:id "myInput" :type "text" :name "myCountry" :placeholder "Country"} ]]
     [curr-states-list]
     [:input {:type "submit"}] ] ])

(defonce counter (atom 0))

(defn run []
  (r/render [simple-component] (js/document.getElementById "tgt-div")))

(defn figwheel-reload []
  ; optionally touch your app-state to force rerendering depending on your application
  ; (swap! app-state update-in [:__figwheel_counter] inc)
  (println "Reloading: " (swap! counter inc)))

(when (zero? @counter)
  (println "Initial load")
  (figwheel-reload))
(run)

