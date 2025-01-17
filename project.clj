(defproject afterglow "0.2.2-SNAPSHOT"
  :description "A live-coding environment for light shows, built on the Open Lighting Architecture, using bits of Overtone."
  :url "https://github.com/brunchboy/afterglow"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :jvm-opts ["-Dapple.awt.UIElement=true"]  ; Suppress dock icon and focus stealing when compiling on a Mac.
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/core.cache "0.6.5"]
                 [org.clojure/core.async "0.2.374" :exclusions [org.clojure/tools.reader]]
                 [org.clojure/data.json "0.2.6"]
                 [org.clojure/data.zip "0.1.1"]
                 [org.clojure/math.numeric-tower "0.0.4"]
                 [org.clojure/tools.cli "0.3.3"]
                 [org.clojure/tools.nrepl "0.2.12"]
                 [org.clojure/tools.reader "0.10.0"]
                 [org.deepsymmetry/wayang "0.1.4"]
                 [java3d/vecmath "1.3.1"]
                 [java3d/j3d-core "1.3.1"]
                 [java3d/j3d-core-utils "1.3.1"]
                 [overtone/at-at "1.2.0"]
                 [overtone/midi-clj "0.5.0"]
                 [overtone/osc-clj "0.9.0"]
                 [uk.co.xfactory-librarians/coremidi4j "0.6-SNAPSHOT"]
                 [amalloy/ring-buffer "1.2" :exclusions [org.clojure/tools.reader
                                                         com.google.protobuf/protobuf-java]]
                 [com.climate/claypoole "1.1.2"]
                 [org.clojars.brunchboy/protobuf "0.8.3"]
                 [ola-clojure "0.1.6-SNAPSHOT" :exclusions [org.clojure/tools.reader]]
                 [selmer "1.0.4"]
                 [com.evocomputing/colors "1.0.3"]
                 [environ "1.0.2"]
                 [camel-snake-kebab "0.3.2"]
                 [com.taoensso/timbre "4.3.1"]
                 [com.taoensso/tower "3.0.2"]
                 [com.taoensso/truss "1.2.0"]
                 [markdown-clj "0.9.87"]
                 [compojure "1.5.0" :exclusions [org.eclipse.jetty/jetty-server
                                                 clj-time]]
                 [ring/ring-defaults "0.2.0"]
                 [ring/ring-session-timeout "0.1.0"]
                 [ring-middleware-format "0.7.0" :exclusions [ring/ring-jetty-adapter
                                                              org.clojure/tools.reader
                                                              org.clojure/java.classpath
                                                              org.clojure/core.memoize]]
                 [metosin/ring-http-response "0.6.5"]
                 [prone "1.1.1"]
                 [buddy "0.12.0"]
                 [instaparse "1.4.1"]
                 [http-kit "2.1.19"]]
  :main afterglow.core
  :uberjar-name "afterglow.jar"
  :manifest {"Name" ~#(str (clojure.string/replace (:group %) "." "/")
                            "/" (:name %) "/")
             "Package" ~#(str (:group %) "." (:name %))
             "Specification-Title" ~#(:name %)
             "Specification-Version" ~#(:version %)}
  :deploy-repositories [["snapshots" :clojars
                         "releases" :clojars]]

  ;; enable to start the nREPL server when the application launches
  ;; :env {:repl-port 16002}

  :profiles {:dev {:dependencies [[ring-mock "0.1.5"]
                                  [ring/ring-devel "1.4.0"]]
                   :repl-options {:init-ns afterglow.examples
                                  :welcome (println "afterglow loaded.")}
                   :jvm-opts ["-XX:-OmitStackTraceInFastThrow" "-Dapple.awt.UIElement=true"]
                   :env {:dev "true"}}
             :uberjar {:env {:production "true"}
                       :aot :all}}
  :plugins [[lein-codox "0.9.4"]
            [org.clojars.brunchboy/lein-dash "0.2.1-SNAPSHOT"]
            [lein-environ "1.0.2"]]

  :codox {:output-path "api-doc"
          :source-uri "https://github.com/brunchboy/afterglow/blob/master/{filepath}#L{line}"
          :metadata {:doc/format :markdown}}
  :min-lein-version "2.0.0")
