(ns maps
  (:require [clojure.walk :refer [keywordize-keys]]))

;; create a map
(def movie {:name "scarface"
            :rating 10})

;; fetch data from a map
(get movie :name)
(movie :name)
(:name movie)

;; add data to a map
(assoc movie :actors ["Alpaca"] :release-date "1921")

;; remove data from a map
(dissoc movie :name)

;; merge maps together
(def movie-info {:actors ["Alpaca"] 
                 :release-date "1921"})

(merge movie movie-info)

(def movie-info2 {:name "other name"
                  :actors ["Alpaca"]
                 :release-date "1921"})

(merge movie movie-info2)

(merge-with + {:a 1} {:b 2})

(merge-with + {:a 1} {:a 2})

(merge-with (fn [val1 val2] (str "concat " (str val1 val2))) {:a 1} {:a 2})

;; zipmap
(zipmap ["hey"] ["there"])

;; get keys
(keys movie)

;; get values
(vals movie)

(zipmap (keys movie) (vals movie-info2))

;; transform keys to keywords
(def user {"name" "on the code again"})
(:name (keywordize-keys user))

;; convert key to string
(name ::movie-name)
(str (namespace ::movie-name) "/" (name ::movie-name))

;; sorted map
(sorted-map :z "Zed" :a "Arn")

(sorted-map-by (fn [key1 key2] (> (count key1) (count key2))) "a" 1 "b" 2 "c" 3)

;; destructuring maps in a function
(defn print-movie-rating [{:keys [name rating] :as m}] (println name "was rated" rating "out of 10") (println m))

(print-movie-rating movie)