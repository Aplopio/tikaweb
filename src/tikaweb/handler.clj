(ns tikaweb.handler
  (:require [compojure.core :refer :all]
            [compojure.handler :as handler]
            [compojure.route :as route]
            [ring.middleware [multipart-params :as mp]]
            [ring.util.response :refer [response]]
            [ring.middleware.json :as middleware]
            [ring.middleware.logger :as logger]
            [onelog.core :as log]
            [tika :as tika]))

(defroutes app-routes
  (GET "/" [] "Hello World")
  (mp/wrap-multipart-params
   (POST "/" {params :params}
         (log/info params)
         (let [parsed-dict (tika/parse (:tempfile (:file params)))]
           ;; (println parsed-dict)
           (response parsed-dict))))
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (-> (handler/site app-routes)
      (middleware/wrap-json-body)
      (middleware/wrap-json-response)
      (logger/wrap-with-logger)))
