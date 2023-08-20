(ns app.components
  (:require [app.conversion :refer [calculate-result]]))

(defn imperial-height-input [state]
  (let [{:keys [form]} @state]
    [:div
     [:input {:type "number"
              :placeholder "feet"
              :value (:ft form)
              :on-change #(swap! state assoc-in [:form :ft] (.. % -target -value))}]
     [:input {:type "number"
              :placeholder "in"
              :value (:in form)
              :on-change #(swap! state assoc-in [:form :in] (.. % -target -value))}]]))

(defn metric-height-input [state]
  (let [{:keys [form]} @state]
    [:div
     [:input {:type "number"
              :placeholder "cm"
              :value (:cm form)
              :on-change #(swap! state assoc-in [:form :cm] (.. % -target -value))}]]))

(defn calculator-form [state]
  (let [{:keys [units
                form]} @state]
    [:form {:on-submit #(do
                          (.preventDefault %)
                          (js/console.log form)
                          (swap! state assoc :result (calculate-result form units)))}
     [:div
      [:label "Units"]
      [:input {:type "radio"
               :checked (= units :imperial)
               :on-change #(do
                             (swap! state assoc :form {})
                             (swap! state assoc :units :imperial))}]
      [:input {:type "radio"
               :checked (= units :metric)
               :on-change #(do
                             (swap! state assoc :form {})
                             (swap! state assoc :units :metric))}]]
     [:div
      [:label "Age"]
      [:input {:type "number"
               :value (:age form)
               :on-change #(swap! state assoc-in [:form :age] (.. % -target -value))}]]
     [:div
      [:label "Gender"]
      [:input {:type "radio"
               :value :male
               :checked (= (:gender form) :male)
               :on-change #(swap! state assoc-in [:form :gender] :male)}]
      [:input {:type "radio"
               :value :female
               :checked (= (:gender form) :female)
               :on-change #(swap! state assoc-in [:form :gender] :female)}]]
     [:div
      [:label "Weight"]
      [:input {:type "text"
               :value (:weight form)
               :placeholder (if (= units :imperial)
                              "pounds"
                              "kg")
               :on-change #(swap! state assoc-in [:form :weight] (.. % -target -value))}]]
     [:div
      [:label "Height"]
      (if (= units :imperial)
        [imperial-height-input state]
        [metric-height-input state])]
     [:button {:type "submit"}
      "Submit"]]))

(defn results-card []
  [:div])
