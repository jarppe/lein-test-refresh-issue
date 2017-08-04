(defproject test-refresh-managed-deps-issue/app "0.1.0-SNAPSHOT"
  :plugins [[lein-parent "0.3.1"]]
  :parent-project {:path "../project.clj"
                   :inherit [:managed-dependencies]}

  :dependencies [[org.clojure/clojure "1.9.0-alpha17"]
                 [clj-time]])
