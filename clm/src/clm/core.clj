(ns clm.core
  (:import (edu.berkeley.nlp.lm.io LmReaders))
  (:require [clojure.string :as string]))

(defn load-goog-lm []
  (let [modeldir (System/getenv "LMDIR")
        vocab (str modeldir "/vocab_cs.gz")
        lm    (str modeldir "/eng.blm")]
    (if (empty? modeldir)
      (-> "LMDIR is not set" Exception. throw)
      (LmReaders/readGoogleLmBinary lm vocab))))

(defmulti logprob (fn [lm x] (class x)) :default nil)

(defmethod logprob 
  java.lang.String
  [lm sentence]
  (let [array (-> sentence (string/split #"\s+") java.util.ArrayList.)]
    (logprob lm array)))

(defmethod logprob
  java.util.List
  [lm sentence]
  (.getLogProb lm sentence))


