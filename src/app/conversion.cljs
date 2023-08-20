(ns app.conversion)

(defn ft->in [n]
  (* n 12))

(defn in->cm [n]
  (* n 2.54))

(defn lbs->kg [n]
  (* n 0.45359237))

;; https://www.gatewaypsychiatric.com/calculating-calorie-needs/
(defn male-bmr [w h a]
  (+ 66
     (* 13.7 w)
     (* 6 h)
     (- (* 6.8 a))))

(defn female-bmr [w h a]
  (+ 655
     (* 9.6 w)
     (* 1.8 h)
     (- (* 4.7 a))))

(defn calculate-result [form units]
  (let [{:keys [age
                weight
                gender]} form
        weight (if (= units :imperial)
                 (lbs->kg weight)
                 weight)
        height (if (= units :imperial)
                 (in->cm (+ (ft->in (:ft form))
                            (int (:in form))))
                 (:cm form))
        bmr (if (= gender :male)
              male-bmr
              female-bmr)]
    (bmr weight height age)))

(def activity-factor
  {:sedentary 1.2
   :light 1.375
   :moderate 1.55
   :very 1.725
   :extreme 1.9})
