(ns org.stuff.clojuroid.main)

; list 9-2

(use 'neko.resource 'neko.activity 'neko.notify 'neko.ui 'neko.threading 'neko.application)

(on-ui
  (set-content-view! a
    (make-ui [:linear-layout {}
              [:text-view {:text (str "Hello from Clojure!" (java.util.Date.))}]])))

(defn some-callback [_]
  (toast "finished" :short))

;(on-ui
;  (set-content-view! a
;    (make-ui [:linear-layout {:layout-height :fill}
;      [:button {:def hello :text "A Button" :on-click some-callback :enabled true}]])))
(on-ui
  (set-content-view! a
    (make-ui [:linear-layout {:layout-height :fill}
      [:button {:text "A Button" :on-click some-callback :enabled true}]])))

(def icon-rsc
  (get-resource :drawable :ic-launcher))

(fire :new-mail
      (notification :icon icon-rsc
                    :ticker "You've got mail"
                    :content-title "One new message"
                    :content-text "FROM: foo@bar.com"
                    :action [:activity "my.package.VIEW_MAIL"]))