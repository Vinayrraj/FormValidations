/*
 * Copyright 2013 Philip Schiffer
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 */

package de.psdev.formvalidations.validations;

import org.junit.Before;
import org.junit.Test;
import org.robolectric.annotation.Config;

import static org.junit.Assert.*;

public class IsPositiveIntegerTest extends BaseValidationTest {

    private Validation mIsPositiveInteger;

    @Before
    public void setUp() throws Exception {
        mIsPositiveInteger = IsPositiveInteger.build();
    }

    @Test
    public void testGetErrorMessage() throws Exception {
        final String errorMessage = mIsPositiveInteger.getErrorMessage(mActivity);
        assertNotNull(errorMessage);
    }

    @Test
    public void testPositiveNumberIsValid() throws Exception {
        assertTrue(mIsPositiveInteger.isValid("1"));
    }

    @Test
    public void testNegativeNumberIsNotValid() throws Exception {
        assertFalse(mIsPositiveInteger.isValid("-1"));
    }

    @Test
    public void testTextIsNotValid() throws Exception {
        assertFalse(mIsPositiveInteger.isValid("text"));
    }
}
