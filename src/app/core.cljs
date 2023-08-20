(ns app.core
  (:require [reagent.dom :as rdom]))

(defn app []
  [:div "hello world"])

(defn ^:dev/after-load reload []
  (rdom/render [app]
               (.getElementById js/document "app"))
  (js/console.log "reloaded"))

(defn ^:export init []
  (js/console.log "application starting")
  (reload))
