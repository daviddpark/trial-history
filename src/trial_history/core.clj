(ns trial-history.core
  (:require [net.cgrand.enlive-html :as html]))

(def ctgov "https://clinicaltrials.gov")

(defn fetch-url [url]
  (html/html-resource (java.net.URL. url)))

(defn trial-history
  "Generate a sequence of patches representing the history of a trial relative to it's current state."
  [nctid]
  (println nctid)
  (let [archive-page (fetch-url (str ctgov "/archive/" nctid))]
    (html/select archive-page [:tr.version])))

(trial-history "NCT00836407")
