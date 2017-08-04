# lein-test-refresh problem with managed dependencies

Lein test works just fine.

```
$ lein test

lein test foo-test

Ran 1 tests containing 1 assertions.
0 failures, 0 errors.
```

Lein test-refresh fails:

```
$ lein test-refresh
Exception in thread "main" java.lang.AssertionError: Assert failed: (dep-spec? dep-spec)
	at leinjacker.deps$dep_name.invokeStatic(deps.clj:23)
	at leinjacker.deps$dep_name.invoke(deps.clj:23)
	at leinjacker.deps$has_dep_QMARK_$fn__968.invoke(deps.clj:41)
	at clojure.core$some.invokeStatic(core.clj:2592)
	at clojure.core$some.invoke(core.clj:2583)
	at leinjacker.deps$has_dep_QMARK_.invokeStatic(deps.clj:41)
	at leinjacker.deps$has_dep_QMARK_.invoke(deps.clj:30)
	at leinjacker.deps$add_if_missing.invokeStatic(deps.clj:50)
	at leinjacker.deps$add_if_missing.invoke(deps.clj:43)
	at leiningen.test_refresh$add_deps.invokeStatic(test_refresh.clj:10)
	at leiningen.test_refresh$add_deps.invoke(test_refresh.clj:8)
	at leiningen.test_refresh$test_refresh.invokeStatic(test_refresh.clj:58)
	at leiningen.test_refresh$test_refresh.doInvoke(test_refresh.clj:46)
	at clojure.lang.RestFn.invoke(RestFn.java:410)
	at clojure.lang.Var.invoke(Var.java:379)
	at clojure.lang.AFn.applyToHelper(AFn.java:154)
	at clojure.lang.Var.applyTo(Var.java:700)
	at clojure.core$apply.invokeStatic(core.clj:648)
	at clojure.core$apply.invoke(core.clj:641)
	at leiningen.core.main$partial_task$fn__5932.doInvoke(main.clj:272)
	at clojure.lang.RestFn.invoke(RestFn.java:410)
	at clojure.lang.AFn.applyToHelper(AFn.java:154)
	at clojure.lang.RestFn.applyTo(RestFn.java:132)
	at clojure.lang.AFunction$1.doInvoke(AFunction.java:29)
	at clojure.lang.RestFn.applyTo(RestFn.java:137)
	at clojure.core$apply.invokeStatic(core.clj:648)
	at clojure.core$apply.invoke(core.clj:641)
	at leiningen.core.main$apply_task.invokeStatic(main.clj:322)
	at leiningen.core.main$apply_task.invoke(main.clj:308)
	at leiningen.core.main$resolve_and_apply.invokeStatic(main.clj:328)
	at leiningen.core.main$resolve_and_apply.invoke(main.clj:324)
	at leiningen.core.main$_main$fn__5998.invoke(main.clj:401)
	at leiningen.core.main$_main.invokeStatic(main.clj:394)
	at leiningen.core.main$_main.doInvoke(main.clj:391)
	at clojure.lang.RestFn.invoke(RestFn.java:408)
	at clojure.lang.Var.invoke(Var.java:379)
	at clojure.lang.AFn.applyToHelper(AFn.java:154)
	at clojure.lang.Var.applyTo(Var.java:700)
	at clojure.core$apply.invokeStatic(core.clj:646)
	at clojure.main$main_opt.invokeStatic(main.clj:314)
	at clojure.main$main_opt.invoke(main.clj:310)
	at clojure.main$main.invokeStatic(main.clj:421)
	at clojure.main$main.doInvoke(main.clj:384)
	at clojure.lang.RestFn.invoke(RestFn.java:436)
	at clojure.lang.Var.invoke(Var.java:388)
	at clojure.lang.AFn.applyToHelper(AFn.java:160)
	at clojure.lang.Var.applyTo(Var.java:700)
	at clojure.main.main(main.java:37)
```

If you change the dependency in `project.clj` from managed

`[clj-time]`

to regular:

`[clj-time "0.14.0"]`

then test-refresh works again:

```
$ lein test-refresh
*********************************************
*************** Running tests ***************
:reloading (foo foo-test)

Testing foo-test

Ran 1 tests containing 1 assertions.
0 failures, 0 errors.

Passed all tests
Finished at 18:17:51.118 (run time: 0.027s)
```
