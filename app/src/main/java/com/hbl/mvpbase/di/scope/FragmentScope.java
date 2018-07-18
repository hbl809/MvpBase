package com.hbl.mvpbase.di.scope;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;
/**
 * Fragment生命周期表示
 */
@Scope
@Retention(RUNTIME)
public @interface FragmentScope {
}
