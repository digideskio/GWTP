/**
 * Copyright 2011 ArcBees Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package com.gwtplatform.mvp.rebind.util;

import com.google.gwt.dev.javac.testing.impl.MockJavaResource;
import com.google.gwt.dev.resource.Resource;
import com.google.gwt.dev.util.RealJavaResource;
import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.inject.client.AsyncProvider;
import com.google.gwt.inject.client.GinModule;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.gwtplatform.mvp.client.ApplicationController;
import com.gwtplatform.mvp.client.Bootstrapper;
import com.gwtplatform.mvp.client.PreBootstrapper;
import com.gwtplatform.mvp.client.proxy.Gatekeeper;

/**
 * Contains GWTP and dependency sources for testing.
 */
public class ResourceBase {
    public static final MockJavaResource DEFAULT_BOOTSTRAPPER =
            new MockJavaResource("com.gwtplatform.mvp.client.DefaultBootstrapper") {
                @Override
                public CharSequence getContent() {
                    StringBuilder code = new StringBuilder();
                    code.append("package com.gwtplatform.mvp.client;\n");
                    code.append("public class DefaultBootstrapper implements Bootstrapper {\n");
                    code.append("  public void onBootstrap() {};\n");
                    code.append("}\n");
                    return code;
                }
            };

    public static final MockJavaResource GINBINDER =
            new MockJavaResource("com.google.gwt.inject.client.binder.GinBinder") {
                @Override
                public CharSequence getContent() {
                    StringBuilder code = new StringBuilder();
                    code.append("package com.google.gwt.inject.client.binder;\n");
                    code.append("public interface GinBinder {\n");
                    code.append("}\n");
                    return code;
                }
            };

    public static final MockJavaResource JAVAXPROVIDER =
            new MockJavaResource("javax.inject.Provider") {
                @Override
                public CharSequence getContent() {
                    StringBuilder code = new StringBuilder();
                    code.append("package javax.inject;\n");
                    code.append("public interface Provider<T> {\n");
                    code.append("}\n");
                    return code;
                }
            };

    public static final MockJavaResource EVENT =
            new MockJavaResource("com.google.web.bindery.event.shared.Event") {
                @Override
                public CharSequence getContent() {
                    StringBuilder code = new StringBuilder();
                    code.append("package com.google.web.bindery.event.shared;\n");
                    code.append("public abstract class Event<H> {\n");
                    code.append("  public static class Type<H> {}\n");
                    code.append("}\n");
                    return code;
                }
            };

    public static final MockJavaResource GWTEVENT =
            new MockJavaResource("com.google.gwt.event.shared.GwtEvent") {
                @Override
                public CharSequence getContent() {
                    StringBuilder code = new StringBuilder();
                    code.append("package com.google.gwt.event.shared;\n");
                    code.append("import com.google.web.bindery.event.shared.Event;\n");
                    code.append("public abstract class GwtEvent<H extends EventHandler> extends Event<H> {\n");
                    code.append("  public static class Type<H> extends com.google.web.bindery.event.shared.Event.Type<H> {}\n");
                    code.append("}\n");
                    return code;
                }
            };

    public static final MockJavaResource BARMODULE =
            new MockJavaResource("com.gwtplatform.mvp.rebind.model.BarModule") {
                @Override
                public CharSequence getContent() {
                    StringBuilder code = new StringBuilder();
                    code.append("package com.gwtplatform.mvp.rebind.model;\n");
                    code.append("import com.google.gwt.inject.client.binder.GinBinder;\n");
                    code.append("public class BarModule {\n");
                    code.append("  public void configure(GinBinder binder) {}\n");
                    code.append("}\n");
                    return code;
                }
            };

    public static final MockJavaResource FOOMODULE =
            new MockJavaResource("com.gwtplatform.mvp.rebind.model.FooModule") {
                @Override
                public CharSequence getContent() {
                    StringBuilder code = new StringBuilder();
                    code.append("package com.gwtplatform.mvp.rebind.model;\n");
                    code.append("import com.google.gwt.inject.client.binder.GinBinder;\n");
                    code.append("public class FooModule {\n");
                    code.append("  public void configure(GinBinder binder) {}\n");
                    code.append("}\n");
                    return code;
                }
            };

    public static final MockJavaResource CUSTOMBOOTSTRAPPER1 =
            new MockJavaResource("com.gwtplatform.mvp.rebind.model.CustomBootstrapper1") {
                @Override
                public CharSequence getContent() {
                    StringBuilder code = new StringBuilder();
                    code.append("package com.gwtplatform.mvp.rebind.model;\n");
                    code.append("import com.gwtplatform.mvp.client.Bootstrapper;\n");
                    code.append("import com.gwtplatform.mvp.client.annotations.Bootstrap;\n");
                    code.append("@Bootstrap\n");
                    code.append("public class CustomBootstrapper1 implements Bootstrapper {\n");
                    code.append("  public void onBootstrap() {}\n");
                    code.append("}\n");
                    return code;
                }
            };

    public static final MockJavaResource CUSTOMBOOTSTRAPPER2 =
            new MockJavaResource("com.gwtplatform.mvp.rebind.model.CustomBootstrapper2") {
                @Override
                public CharSequence getContent() {
                    StringBuilder code = new StringBuilder();
                    code.append("package com.gwtplatform.mvp.rebind.model;\n");
                    code.append("import com.gwtplatform.mvp.client.Bootstrapper;\n");
                    code.append("import com.gwtplatform.mvp.client.annotations.Bootstrap;\n");
                    code.append("@Bootstrap\n");
                    code.append("public class CustomBootstrapper2 implements Bootstrapper {\n");
                    code.append("  public void onBootstrap() {}\n");
                    code.append("}\n");
                    return code;
                }
            };

    public static final MockJavaResource CUSTOMBOOTSTRAPPER3 =
            new MockJavaResource("com.gwtplatform.mvp.rebind.model.CustomBootstrapper3") {
                @Override
                public CharSequence getContent() {
                    StringBuilder code = new StringBuilder();
                    code.append("package com.gwtplatform.mvp.rebind.model;\n");
                    code.append("import com.gwtplatform.mvp.client.annotations.Bootstrap;\n");
                    code.append("@Bootstrap\n");
                    code.append("public class CustomBootstrapper3 {\n");
                    code.append("}\n");
                    return code;
                }
            };

    public static final MockJavaResource CUSTOMPREBOOTSTRAPPER1 =
            new MockJavaResource("com.gwtplatform.mvp.rebind.model.CustomPreBootstrapper1") {
                @Override
                public CharSequence getContent() {
                    StringBuilder code = new StringBuilder();
                    code.append("package com.gwtplatform.mvp.rebind.model;\n");
                    code.append("import com.gwtplatform.mvp.client.PreBootstrapper;\n");
                    code.append("import com.gwtplatform.mvp.client.annotations.PreBootstrap;\n");
                    code.append("@PreBootstrap\n");
                    code.append("public class CustomPreBootstrapper1 implements PreBootstrapper {\n");
                    code.append("  public void onPreBootstrap() {}\n");
                    code.append("}\n");
                    return code;
                }
            };

    public static final MockJavaResource CUSTOMPREBOOTSTRAPPER2 =
            new MockJavaResource("com.gwtplatform.mvp.rebind.model.CustomPreBootstrapper2") {
                @Override
                public CharSequence getContent() {
                    StringBuilder code = new StringBuilder();
                    code.append("package com.gwtplatform.mvp.rebind.model;\n");
                    code.append("import com.gwtplatform.mvp.client.PreBootstrapper;\n");
                    code.append("import com.gwtplatform.mvp.client.annotations.PreBootstrap;\n");
                    code.append("@PreBootstrap\n");
                    code.append("public class CustomPreBootstrapper2 implements PreBootstrapper {\n");
                    code.append("  public void onPreBootstrap() {}\n");
                    code.append("}\n");
                    return code;
                }
            };

    public static final MockJavaResource CUSTOMPREBOOTSTRAPPER3 =
            new MockJavaResource("com.gwtplatform.mvp.rebind.model.CustomPreBootstrapper3") {
                @Override
                public CharSequence getContent() {
                    StringBuilder code = new StringBuilder();
                    code.append("package com.gwtplatform.mvp.rebind.model;\n");
                    code.append("import com.gwtplatform.mvp.client.annotations.PreBootstrap;\n");
                    code.append("@PreBootstrap\n");
                    code.append("public class CustomPreBootstrapper3 {\n");
                    code.append("}\n");
                    return code;
                }
            };

    public static final MockJavaResource GINJECTOR_RETURNVALUE1 =
            new MockJavaResource("com.gwtplatform.mvp.rebind.model.ReturnValue1") {
                @Override
                public CharSequence getContent() {
                    StringBuilder code = new StringBuilder();
                    code.append("package com.gwtplatform.mvp.rebind.model;\n");
                    code.append("public interface ReturnValue1 {\n");
                    code.append("}\n");
                    return code;
                }
            };

    public static final MockJavaResource GINJECTOR_RETURNVALUE2 =
            new MockJavaResource("com.gwtplatform.mvp.rebind.model.ReturnValue2") {
                @Override
                public CharSequence getContent() {
                    StringBuilder code = new StringBuilder();
                    code.append("package com.gwtplatform.mvp.rebind.model;\n");
                    code.append("public interface ReturnValue2 {\n");
                    code.append("}\n");
                    return code;
                }
            };

    public static final MockJavaResource GINJECTOREXTENSION1 =
            new MockJavaResource("com.gwtplatform.mvp.rebind.model.GinjectorExtension1") {
                @Override
                public CharSequence getContent() {
                    StringBuilder code = new StringBuilder();
                    code.append("package com.gwtplatform.mvp.rebind.model;\n");
                    code.append("public interface GinjectorExtension1 {\n");
                    code.append("  ReturnValue1 getReturnValue1();\n");
                    code.append("}\n");
                    return code;
                }
            };

    public static final MockJavaResource GINJECTOREXTENSION2 =
            new MockJavaResource("com.gwtplatform.mvp.rebind.model.GinjectorExtension2") {
                @Override
                public CharSequence getContent() {
                    StringBuilder code = new StringBuilder();
                    code.append("package com.gwtplatform.mvp.rebind.model;\n");
                    code.append("public interface GinjectorExtension2 {\n");
                    code.append("  ReturnValue2 getReturnValue2();\n");
                    code.append("}\n");
                    return code;
                }
            };

    public static final MockJavaResource GINJECTOREXTENSION3 =
            new MockJavaResource("com.gwtplatform.mvp.rebind.model.GinjectorExtension3") {
                @Override
                public CharSequence getContent() {
                    StringBuilder code = new StringBuilder();
                    code.append("package com.gwtplatform.mvp.rebind.model;\n");
                    code.append("public interface GinjectorExtension3 {\n");
                    code.append("  ReturnValue1 getReturnValue1();\n");
                    code.append("}\n");
                    return code;
                }
            };

    public static final MockJavaResource GINJECTOREXTENSION4 =
            new MockJavaResource("com.gwtplatform.mvp.rebind.model.GinjectorExtension4") {
                @Override
                public CharSequence getContent() {
                    StringBuilder code = new StringBuilder();
                    code.append("package com.gwtplatform.mvp.rebind.model;\n");
                    code.append("public interface GinjectorExtension4 {\n");
                    code.append("  ReturnValue1 getReturnValue();\n");
                    code.append("}\n");
                    return code;
                }
            };

    public static final MockJavaResource PRESENTER1 =
            new MockJavaResource("com.gwtplatform.mvp.rebind.model.Presenter1") {
                @Override
                public CharSequence getContent() {
                    StringBuilder code = new StringBuilder();
                    code.append("package com.gwtplatform.mvp.rebind.model;\n");
                    code.append("import com.gwtplatform.mvp.client.Presenter;\n");
                    code.append("import com.gwtplatform.mvp.client.View;\n");
                    code.append("import com.gwtplatform.mvp.client.proxy.Proxy;\n");
                    code.append("import com.google.web.bindery.event.shared.EventBus;\n");
                    code.append("import com.gwtplatform.mvp.client.annotations.ProxyStandard;\n");
                    code.append("public class Presenter1 extends Presenter<Presenter1.MyView, Presenter1.MyProxy> {\n");
                    code.append("  @ProxyStandard\n");
                    code.append("  public interface MyProxy extends Proxy<Presenter1> {}\n");
                    code.append("  public interface MyView extends View {}\n");
                    code.append("}\n");
                    return code;
                }
            };

    public static final MockJavaResource PRESENTER2 =
            new MockJavaResource("com.gwtplatform.mvp.rebind.model.Presenter2") {
                @Override
                public CharSequence getContent() {
                    StringBuilder code = new StringBuilder();
                    code.append("package com.gwtplatform.mvp.rebind.model;\n");
                    code.append("import com.gwtplatform.mvp.client.Presenter;\n");
                    code.append("import com.gwtplatform.mvp.client.View;\n");
                    code.append("import com.gwtplatform.mvp.client.proxy.Proxy;\n");
                    code.append("import com.google.web.bindery.event.shared.EventBus;\n");
                    code.append("import com.gwtplatform.mvp.client.annotations.ProxyStandard;\n");
                    code.append("public class Presenter2 extends Presenter<Presenter2.MyView, Presenter2.MyProxy> {\n");
                    code.append("  @ProxyStandard\n");
                    code.append("  public interface MyProxy extends Proxy<Presenter2> {}\n");
                    code.append("  public interface MyView extends View {}\n");
                    code.append("}\n");
                    return code;
                }
            };

    public static final MockJavaResource PRESENTERASYNC =
            new MockJavaResource("com.gwtplatform.mvp.rebind.model.Presenter3") {
                @Override
                public CharSequence getContent() {
                    StringBuilder code = new StringBuilder();
                    code.append("package com.gwtplatform.mvp.rebind.model;\n");
                    code.append("import com.gwtplatform.mvp.client.Presenter;\n");
                    code.append("import com.gwtplatform.mvp.client.View;\n");
                    code.append("import com.gwtplatform.mvp.client.proxy.Proxy;\n");
                    code.append("import com.google.web.bindery.event.shared.EventBus;\n");
                    code.append("import com.gwtplatform.mvp.client.annotations.ProxyCodeSplit;\n");
                    code.append("public class Presenter3 extends Presenter<Presenter3.MyView, Presenter3.MyProxy> {\n");
                    code.append("  @ProxyCodeSplit\n");
                    code.append("  public interface MyProxy extends Proxy<Presenter3> {}\n");
                    code.append("  public interface MyView extends View {}\n");
                    code.append("}\n");
                    return code;
                }
            };

    public static final MockJavaResource PRESENTER_CODESPLIT_BUNDLE1 =
            new MockJavaResource("com.gwtplatform.mvp.rebind.model.Presenter4") {
                @Override
                public CharSequence getContent() {
                    StringBuilder code = new StringBuilder();
                    code.append("package com.gwtplatform.mvp.rebind.model;\n");
                    code.append("import com.gwtplatform.mvp.client.Presenter;\n");
                    code.append("import com.gwtplatform.mvp.client.View;\n");
                    code.append("import com.gwtplatform.mvp.client.proxy.Proxy;\n");
                    code.append("import com.google.web.bindery.event.shared.EventBus;\n");
                    code.append("import com.gwtplatform.mvp.client.annotations.ProxyCodeSplitBundle;\n");
                    code.append("public class Presenter4 extends Presenter<Presenter4.MyView, Presenter4.MyProxy> {\n");
                    code.append("  @ProxyCodeSplitBundle(\"Foo\")\n");
                    code.append("  public interface MyProxy extends Proxy<Presenter4> {}\n");
                    code.append("  public interface MyView extends View {}\n");
                    code.append("}\n");
                    return code;
                }
            };

    public static final MockJavaResource PRESENTER_CODESPLIT_BUNDLE2 =
            new MockJavaResource("com.gwtplatform.mvp.rebind.model.Presenter5") {
                @Override
                public CharSequence getContent() {
                    StringBuilder code = new StringBuilder();
                    code.append("package com.gwtplatform.mvp.rebind.model;\n");
                    code.append("import com.gwtplatform.mvp.client.Presenter;\n");
                    code.append("import com.gwtplatform.mvp.client.View;\n");
                    code.append("import com.gwtplatform.mvp.client.proxy.Proxy;\n");
                    code.append("import com.google.web.bindery.event.shared.EventBus;\n");
                    code.append("import com.gwtplatform.mvp.client.annotations.ProxyCodeSplitBundle;\n");
                    code.append("public class Presenter5 extends Presenter<Presenter5.MyView, Presenter5.MyProxy> {\n");
                    code.append("  @ProxyCodeSplitBundle(\"Foo\")\n");
                    code.append("  public interface MyProxy extends Proxy<Presenter5> {}\n");
                    code.append("  public interface MyView extends View {}\n");
                    code.append("}\n");
                    return code;
                }
            };

    public static final MockJavaResource PRESENTER_CODESPLIT_BUNDLE3 =
            new MockJavaResource("com.gwtplatform.mvp.rebind.model.Presenter6") {
                @Override
                public CharSequence getContent() {
                    StringBuilder code = new StringBuilder();
                    code.append("package com.gwtplatform.mvp.rebind.model;\n");
                    code.append("import com.gwtplatform.mvp.client.Presenter;\n");
                    code.append("import com.gwtplatform.mvp.client.View;\n");
                    code.append("import com.gwtplatform.mvp.client.proxy.Proxy;\n");
                    code.append("import com.google.web.bindery.event.shared.EventBus;\n");
                    code.append("import com.gwtplatform.mvp.client.annotations.ProxyCodeSplitBundle;\n");
                    code.append("public class Presenter6 extends Presenter<Presenter6.MyView, Presenter6.MyProxy> {\n");
                    code.append("  @ProxyCodeSplitBundle(\"Bar\")\n");
                    code.append("  public interface MyProxy extends Proxy<Presenter6> {}\n");
                    code.append("  public interface MyView extends View {}\n");
                    code.append("}\n");
                    return code;
                }
            };

    public static final MockJavaResource DEFAULTGATEKEEPER =
            new MockJavaResource("com.gwtplatform.mvp.rebind.model.DefaultGatekeeperImpl") {
                @Override
                public CharSequence getContent() {
                    StringBuilder code = new StringBuilder();
                    code.append("package com.gwtplatform.mvp.rebind.model;\n");
                    code.append("import com.gwtplatform.mvp.client.proxy.Gatekeeper;\n");
                    code.append("import com.gwtplatform.mvp.client.annotations.DefaultGatekeeper;\n");
                    code.append("@DefaultGatekeeper\n");
                    code.append("public class DefaultGatekeeperImpl implements Gatekeeper {\n");
                    code.append("  public boolean canReveal() {return false;}\n");
                    code.append("}\n");
                    return code;
                }
            };

    public static final MockJavaResource PRESENTER_DIFFERENTPACKAGE =
            new MockJavaResource("com.gwtplatform.mvp.rebind.model.foo.Presenter1") {
                @Override
                public CharSequence getContent() {
                    StringBuilder code = new StringBuilder();
                    code.append("package com.gwtplatform.mvp.rebind.model.foo;\n");
                    code.append("import com.gwtplatform.mvp.client.Presenter;\n");
                    code.append("import com.gwtplatform.mvp.client.View;\n");
                    code.append("import com.gwtplatform.mvp.client.proxy.Proxy;\n");
                    code.append("import com.google.web.bindery.event.shared.EventBus;\n");
                    code.append("import com.gwtplatform.mvp.client.annotations.ProxyStandard;\n");
                    code.append("public class Presenter1 extends Presenter<Presenter1.MyView, Presenter1.MyProxy> {\n");
                    code.append("  @ProxyStandard\n");
                    code.append("  public interface MyProxy extends Proxy<Presenter1> {}\n");
                    code.append("  public interface MyView extends View {}\n");
                    code.append("}\n");
                    return code;
                }
            };

    public static final MockJavaResource PROXY =
            new MockJavaResource("com.gwtplatform.mvp.client.proxy.Proxy") {
                @Override
                public CharSequence getContent() {
                    StringBuilder code = new StringBuilder();
                    code.append("package com.gwtplatform.mvp.client.proxy;\n");
                    code.append("import com.gwtplatform.mvp.client.Presenter;\n");
                    code.append("public interface Proxy<P extends Presenter<?, ?>> {\n");
                    code.append("}\n");
                    return code;
                }
            };

    public static final MockJavaResource PLACE =
            new MockJavaResource("com.gwtplatform.mvp.client.proxy.Place") {
                @Override
                public CharSequence getContent() {
                    StringBuilder code = new StringBuilder();
                    code.append("package com.gwtplatform.mvp.client.proxy;\n");
                    code.append("import com.gwtplatform.mvp.client.Presenter;\n");
                    code.append("public interface Place {\n");
                    code.append("}\n");
                    return code;
                }
            };

    public static final MockJavaResource VIEW =
            new MockJavaResource("com.gwtplatform.mvp.client.View") {
                @Override
                public CharSequence getContent() {
                    StringBuilder code = new StringBuilder();
                    code.append("package com.gwtplatform.mvp.client;\n");
                    code.append("public interface View {\n");
                    code.append("}\n");
                    return code;
                }
            };

    public static final MockJavaResource PRESENTER =
            new MockJavaResource("com.gwtplatform.mvp.client.Presenter") {
                @Override
                public CharSequence getContent() {
                    StringBuilder code = new StringBuilder();
                    code.append("package com.gwtplatform.mvp.client;\n");
                    code.append("import com.gwtplatform.mvp.client.proxy.Proxy;\n");
                    code.append("public abstract class Presenter<V extends View, Proxy_ extends Proxy<?>> {\n");
                    code.append("}\n");
                    return code;
                }
            };

    public static Resource[] getResources() {
        return new Resource[]{
                // GWT sources
                GWTEVENT,
                EVENT,
                new RealJavaResource(EventHandler.class),
                new RealJavaResource(AsyncCallback.class),

                // GIN sources
                GINBINDER,
                new RealJavaResource(GinModule.class),
                JAVAXPROVIDER,
                new RealJavaResource(AsyncProvider.class),

                // GWTP sources
                DEFAULT_BOOTSTRAPPER,
                new RealJavaResource(ApplicationController.class),
                new RealJavaResource(Bootstrapper.class),
                new RealJavaResource(PreBootstrapper.class),
                new RealJavaResource(Gatekeeper.class),

                // test sources
                BARMODULE, FOOMODULE,
                GINJECTOR_RETURNVALUE1, GINJECTOR_RETURNVALUE2,
                GINJECTOREXTENSION1, GINJECTOREXTENSION2, GINJECTOREXTENSION3, GINJECTOREXTENSION4,
                PRESENTER, VIEW, PROXY, PLACE
        };
    }
}
