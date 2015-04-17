(defproject clm "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :repositories {"local" ~(str (.toURI (java.io.File. "local_mvn_repo")))}
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [io.aviso/pretty "0.1.17"]
                 [berkeleylm/berkeleylm "1.1.5"]]
  :repl-options { :nrepl-middleware [io.aviso.nrepl/pretty-middleware] })
