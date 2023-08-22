(ns app.app
  (:require [reagent.core :as r]
            [app.components :refer [calculator-form
                                    results-card]]))

(defonce state
  (r/atom {:units :imperial
           :form {}
           :result nil}))

(defn app []
  [:main {:class "sm:bg-gray-200 h-screen sm:flex justify-center items-center"}
   [:div {:class "w-full sm:w-2/3 bg-white mx-auto p-4 sm:rounded"}
    [calculator-form state]
    [results-card state]]])
