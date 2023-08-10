package com.upgrad.MovieApp;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile("stage")
@Component
public class SampleComponentClass {
}
