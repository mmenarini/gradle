/*
 * Copyright 2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.gradle.internal.nativeintegration.console;

public enum TestConsoleMetadata implements ConsoleMetaData {
    BOTH(true, true),
    NEITHER(false, false),
    STDOUT_ONLY(true, false),
    STDERR_ONLY(false, true);

    public static final String TEST_CONSOLE_PROPERTY = "org.gradle.internal.console.test-console";

    private final boolean attachedToStdout;
    private final boolean attachedToStderr;

    TestConsoleMetadata(boolean attachedToStdout, boolean attachedToStderr) {
        this.attachedToStdout = attachedToStdout;
        this.attachedToStderr = attachedToStderr;
    }

    @Override
    public boolean isStdOut() {
        return attachedToStdout;
    }

    @Override
    public boolean isStdErr() {
        return attachedToStderr;
    }

    @Override
    public int getCols() {
        return 0;
    }

    @Override
    public int getRows() {
        return 0;
    }

    public String getCommandLineArgument() {
        return "-D" + TEST_CONSOLE_PROPERTY + "=" + name();
    }
}
