(defproject tikaweb "0.1.0"
  :description "Provide Apache Tika library as a web service."
  :url "http://example.com/FIXME"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [compojure "1.2.0"]
                 [ring/ring-json "0.2.0"]
                 [ring.middleware.logger "0.5.0"]
                 [onelog "0.4.5"]
                 [org.clojars.floriano.clj-tika "1.2.4"]]
  :plugins [[lein-ring "0.8.12"]
            [com.jakemccrary/lein-test-refresh "0.1.2"]]
  :ring {:handler tikaweb.handler/app}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring-mock "0.1.5"]]}})
