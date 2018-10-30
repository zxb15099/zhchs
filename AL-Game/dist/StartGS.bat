@ECHO off

del /q /s cache
del /q /s log
del *.log
del /q /s H:\AL-5.8\AL-Game\data\static_data\spawns\Npcs\New\*.*
 
TITLE Aion German - Game Server Console
:START
CLS
SET JAVAVER=1.7
SET NUMAENABLE=false
CLS
IF "%MODE%" == "" (
SET JAVA_OPTS=-Xms5096m -Xmx8192m -server
)


IF "%JAVAVER%" == "1.7" (
SET JAVA_OPTS=-XX:-UseSplitVerifier -XX:+TieredCompilation %JAVA_OPTS%
)
IF "%NUMAENABLE%" == "true" (
SET JAVA_OPTS=-XX:+UseNUMA %JAVA_OPTS%
)
ECHO Starting Aion German Game Server in Develop mode.
SET PATH="H:\AL-5.8\Java\jre7\bin"
SET PATH="H:\AL-5.8\Java\jdk1.7.0_80\bin"
JAVA %JAVA_OPTS% -ea -javaagent:./libs/al-commons.jar -cp ./libs/*;AL-Game.jar com.aionemu.gameserver.GameServer
SET CLASSPATH=%OLDCLASSPATH%
IF ERRORLEVEL 2 GOTO START
IF ERRORLEVEL 1 GOTO ERROR
IF ERRORLEVEL 0 GOTO END
:ERROR
ECHO.
ECHO Game Server has terminated abnormaly!
ECHO.
PAUSE
EXIT
:END
ECHO.
ECHO Game Server is terminated!
ECHO.
PAUSE
EXIT