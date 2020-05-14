package com.vijay.jsonwizard.shadow;

import com.vijay.jsonwizard.rules.RulesEngineDateUtil;
import com.vijay.jsonwizard.utils.FormUtils;

import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;
import org.robolectric.annotation.Implementation;
import org.robolectric.annotation.Implements;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;

import static com.vijay.jsonwizard.rules.RulesEngineHelperTest.TEST_TIME_EXPECTED;

@Implements(RulesEngineDateUtil.class)
public class ShadowRulesEngineDateUtil {

    @Implementation
    public String getDateTimeToday() {
        Clock clock = Clock.fixed(Instant.parse(TEST_TIME_EXPECTED), ZoneId.systemDefault());
        return new LocalDateTime(clock.millis()).toString("yyyy-MM-dd HH:mm:ss");
    }

    @Implementation
    public String getDateToday() {
        Clock clock = Clock.fixed(Instant.parse(TEST_TIME_EXPECTED), ZoneId.systemDefault());
        return new LocalDate(clock.millis()).toString(FormUtils.NATIIVE_FORM_DATE_FORMAT_PATTERN);
    }
}
