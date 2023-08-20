(ns app.app
  (:require [reagent.core :as r]
            [app.components :refer [calculator-form]]))

(defonce state
  (r/atom {:units :imperial
           :form {}
           :result nil}))

(defn app []
  (js/console.log @state)
  [:div
   [calculator-form state]])
