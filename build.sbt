organization in ThisBuild := "com.example"
version in ThisBuild := "1.0-SNAPSHOT"

// the Scala version that will be used for cross-compiled libraries
scalaVersion in ThisBuild := "2.12.8"

val scalaTest = "org.scalatest" %% "scalatest" % "3.0.1" % Test
val scalaParserCombinators = "org.scala-lang.modules" %% "scala-parser-combinators" % "1.0.5"

lazy val `scala-exercism` = (project in file("."))
  .aggregate(`accumulate`, `acronym`, `allergies`, `all-your-base`, `alphametics`, `anagram`, `armstrong-numbers`,
  `atbash-cipher`, `bank-account`, `beer-song`, `binary-search`, `binary-search-tree`, `bob`, `book-store`,
  `bowling`, `change`, `clock`, `collatz-conjecture`, `complex-numbers`, `connect`, `crypto-square`, `custom-set`, `darts`, `diamond`,
  `difference-of-squares`, `dominoes`, `etl`, `flatten-array`, `food-chain`, `forth`, `gigasecond`, `grade-school`, `grains`,
  `hamming`, `hello-world`, `high-scores`, `house`, `isogram`, `kindergarten-garden`, `largest-series-product`, `leap`, 
  `lens-person`, `linked-list`, `luhn`, `matching-brackets`, `matrix`, `meetup`, `minesweeper`, `nth-prime`,
  `nucleotide-count`, `ocr-numbers`, `palindrome-products`, `pangram`, `parallel-letter-frequency`, `pascals-triangle`,
  `perfect-numbers`, `phone-number`, `pig-latin`, `prime-factors`, `protein-translation`, `pythagorean-triplet`, `queen-attack`,
  `rail-fence-cipher`, `raindrops`, `rna-transcription`, `robot-name`, `robot-simulator`, `roman-numerals`,
  `rotational-cipher`, `run-length-encoding`, `saddle-points`, `say`, `scrabble-score`, `secret-handshake`, `series`,
  `sgf-parsing`, `sieve`, `simple-cipher`, `simple-linked-list`, `space-age`, `spiral-matrix`, `strain`, `sublist`,
  `sum-of-multiples`, `triangle`, `two-fer`, `variable-length-quantity`, `word-count`, `wordy`, `zebra-puzzle`, `zipper`
  )

lazy val `accumulate` = (project in file("accumulate")).settings(libraryDependencies ++= Seq(
      scalaTest))
lazy val `acronym` = (project in file("acronym")).settings(libraryDependencies ++= Seq(
      scalaTest))
lazy val `allergies` = (project in file("allergies")).settings(libraryDependencies ++= Seq(
      scalaTest))
lazy val `all-your-base` = (project in file("all-your-base")).settings(libraryDependencies ++= Seq(
      scalaTest))
lazy val `alphametics` = (project in file("alphametics")).settings(libraryDependencies ++= Seq(
      scalaTest))
lazy val `anagram` = (project in file("anagram")).settings(libraryDependencies ++= Seq(
      scalaTest))
lazy val `armstrong-numbers` = (project in file("armstrong-numbers")).settings(libraryDependencies ++= Seq(
      scalaTest))
lazy val `atbash-cipher` = (project in file("atbash-cipher")).settings(libraryDependencies ++= Seq(
      scalaTest))
lazy val `bank-account` = (project in file("bank-account")).settings(libraryDependencies ++= Seq(
      scalaTest))
lazy val `beer-song` = (project in file("beer-song")).settings(libraryDependencies ++= Seq(
      scalaTest))
lazy val `binary-search` = (project in file("binary-search")).settings(libraryDependencies ++= Seq(
      scalaTest))
lazy val `binary-search-tree` = (project in file("binary-search-tree")).settings(libraryDependencies ++= Seq(
      scalaTest))
lazy val `bob` = (project in file("bob")).settings(libraryDependencies ++= Seq(
      scalaTest))
lazy val `book-store` = (project in file("book-store")).settings(libraryDependencies ++= Seq(
      scalaTest))
lazy val `bowling` = (project in file("bowling")).settings(libraryDependencies ++= Seq(
      scalaTest))
lazy val `change` = (project in file("change")).settings(libraryDependencies ++= Seq(
      scalaTest))
lazy val `clock` = (project in file("clock")).settings(libraryDependencies ++= Seq(
      scalaTest))
lazy val `collatz-conjecture` = (project in file("collatz-conjecture")).settings(libraryDependencies ++= Seq(
      scalaTest))
lazy val `complex-numbers` = (project in file("complex-numbers")).settings(libraryDependencies ++= Seq(
      scalaTest))
lazy val `connect` = (project in file("connect")).settings(libraryDependencies ++= Seq(
      scalaTest))
lazy val `crypto-square` = (project in file("crypto-square")).settings(libraryDependencies ++= Seq(
      scalaTest))
lazy val `custom-set` = (project in file("custom-set")).settings(libraryDependencies ++= Seq(
      scalaTest))
lazy val `darts` = (project in file("darts")).settings(libraryDependencies ++= Seq(
      scalaTest))
lazy val `diamond` = (project in file("diamond")).settings(libraryDependencies ++= Seq(
      scalaTest))
lazy val `difference-of-squares` = (project in file("difference-of-squares")).settings(libraryDependencies ++= Seq(
      scalaTest))
lazy val `dominoes` = (project in file("dominoes")).settings(libraryDependencies ++= Seq(
      scalaTest))
lazy val `etl` = (project in file("etl")).settings(libraryDependencies ++= Seq(
      scalaTest))
lazy val `flatten-array` = (project in file("flatten-array")).settings(libraryDependencies ++= Seq(
      scalaTest))
lazy val `food-chain` = (project in file("food-chain")).settings(libraryDependencies ++= Seq(
      scalaTest))
lazy val `forth` = (project in file("forth")).settings(libraryDependencies ++= Seq(
      scalaTest))
lazy val `gigasecond` = (project in file("gigasecond")).settings(libraryDependencies ++= Seq(
      scalaTest))
lazy val `grade-school` = (project in file("grade-school")).settings(libraryDependencies ++= Seq(
      scalaTest))
lazy val `grains` = (project in file("grains")).settings(libraryDependencies ++= Seq(
      scalaTest))
lazy val `hamming` = (project in file("hamming")).settings(libraryDependencies ++= Seq(
      scalaTest))
lazy val `hello-world` = (project in file("hello-world")).settings(libraryDependencies ++= Seq(
      scalaTest))
lazy val `high-scores` = (project in file("high-scores")).settings(libraryDependencies ++= Seq(
      scalaTest))
lazy val `house` = (project in file("house")).settings(libraryDependencies ++= Seq(
      scalaTest))
lazy val `isogram` = (project in file("isogram")).settings(libraryDependencies ++= Seq(
      scalaTest))
lazy val `kindergarten-garden` = (project in file("kindergarten-garden")).settings(libraryDependencies ++= Seq(
      scalaTest))
lazy val `largest-series-product` = (project in file("largest-series-product")).settings(libraryDependencies ++= Seq(
      scalaTest))
lazy val `leap` = (project in file("leap")).settings(libraryDependencies ++= Seq(
      scalaTest))
lazy val `lens-person` = (project in file("lens-person")).settings(libraryDependencies ++= Seq(
      scalaTest))
lazy val `linked-list` = (project in file("linked-list")).settings(libraryDependencies ++= Seq(
      scalaTest))
lazy val `luhn` = (project in file("luhn")).settings(libraryDependencies ++= Seq(
      scalaTest))
lazy val `matching-brackets` = (project in file("matching-brackets")).settings(libraryDependencies ++= Seq(
      scalaTest))
lazy val `matrix` = (project in file("matrix")).settings(libraryDependencies ++= Seq(
      scalaTest))
lazy val `meetup` = (project in file("meetup")).settings(libraryDependencies ++= Seq(
      scalaTest))
lazy val `minesweeper` = (project in file("minesweeper")).settings(libraryDependencies ++= Seq(
      scalaTest))
lazy val `nth-prime` = (project in file("nth-prime")).settings(libraryDependencies ++= Seq(
      scalaTest))
lazy val `nucleotide-count` = (project in file("nucleotide-count")).settings(libraryDependencies ++= Seq(
      scalaTest))
lazy val `ocr-numbers` = (project in file("ocr-numbers")).settings(libraryDependencies ++= Seq(
      scalaTest))
lazy val `palindrome-products` = (project in file("palindrome-products")).settings(libraryDependencies ++= Seq(
      scalaTest))
lazy val `pangram` = (project in file("pangram")).settings(libraryDependencies ++= Seq(
      scalaTest))
lazy val `parallel-letter-frequency` = (project in file("parallel-letter-frequency")).settings(libraryDependencies ++= Seq(
      scalaTest))
lazy val `pascals-triangle` = (project in file("pascals-triangle")).settings(libraryDependencies ++= Seq(
      scalaTest))
lazy val `perfect-numbers` = (project in file("perfect-numbers")).settings(libraryDependencies ++= Seq(
      scalaTest))
lazy val `phone-number` = (project in file("phone-number")).settings(libraryDependencies ++= Seq(
      scalaTest))
lazy val `pig-latin` = (project in file("pig-latin")).settings(libraryDependencies ++= Seq(
      scalaTest))
lazy val `prime-factors` = (project in file("prime-factors")).settings(libraryDependencies ++= Seq(
      scalaTest))
lazy val `protein-translation` = (project in file("protein-translation")).settings(libraryDependencies ++= Seq(
      scalaTest))
lazy val `pythagorean-triplet` = (project in file("pythagorean-triplet")).settings(libraryDependencies ++= Seq(
      scalaTest))
lazy val `queen-attack` = (project in file("queen-attack")).settings(libraryDependencies ++= Seq(
      scalaTest))
lazy val `rail-fence-cipher` = (project in file("rail-fence-cipher")).settings(libraryDependencies ++= Seq(
      scalaTest))
lazy val `raindrops` = (project in file("raindrops")).settings(libraryDependencies ++= Seq(
      scalaTest))
lazy val `rna-transcription` = (project in file("rna-transcription")).settings(libraryDependencies ++= Seq(
      scalaTest))
lazy val `robot-name` = (project in file("robot-name")).settings(libraryDependencies ++= Seq(
      scalaTest))
lazy val `robot-simulator` = (project in file("robot-simulator")).settings(libraryDependencies ++= Seq(
      scalaTest))
lazy val `roman-numerals` = (project in file("roman-numerals")).settings(libraryDependencies ++= Seq(
      scalaTest))
lazy val `rotational-cipher` = (project in file("rotational-cipher")).settings(libraryDependencies ++= Seq(
      scalaTest))
lazy val `run-length-encoding` = (project in file("run-length-encoding")).settings(libraryDependencies ++= Seq(
      scalaTest))
lazy val `saddle-points` = (project in file("saddle-points")).settings(libraryDependencies ++= Seq(
      scalaTest))
lazy val `say` = (project in file("say")).settings(libraryDependencies ++= Seq(
      scalaTest))
lazy val `scrabble-score` = (project in file("scrabble-score")).settings(libraryDependencies ++= Seq(
      scalaTest))
lazy val `secret-handshake` = (project in file("secret-handshake")).settings(libraryDependencies ++= Seq(
      scalaTest))
lazy val `series` = (project in file("series")).settings(libraryDependencies ++= Seq(
      scalaTest))
lazy val `sgf-parsing` = (project in file("sgf-parsing")).settings(libraryDependencies ++= Seq(
      scalaTest))
lazy val `sieve` = (project in file("sieve")).settings(libraryDependencies ++= Seq(
      scalaTest))
lazy val `simple-cipher` = (project in file("simple-cipher")).settings(libraryDependencies ++= Seq(
      scalaTest))
lazy val `simple-linked-list` = (project in file("simple-linked-list")).settings(libraryDependencies ++= Seq(
      scalaTest))
lazy val `space-age` = (project in file("space-age")).settings(libraryDependencies ++= Seq(
      scalaTest))
lazy val `spiral-matrix` = (project in file("spiral-matrix")).settings(libraryDependencies ++= Seq(
      scalaTest))
lazy val `strain` = (project in file("strain")).settings(libraryDependencies ++= Seq(
      scalaTest))
lazy val `sublist` = (project in file("sublist")).settings(libraryDependencies ++= Seq(
      scalaTest))
lazy val `sum-of-multiples` = (project in file("sum-of-multiples")).settings(libraryDependencies ++= Seq(
      scalaTest))
lazy val `triangle` = (project in file("triangle")).settings(libraryDependencies ++= Seq(
      scalaTest))
lazy val `two-fer` = (project in file("two-fer")).settings(libraryDependencies ++= Seq(
      scalaTest))
lazy val `variable-length-quantity` = (project in file("variable-length-quantity")).settings(libraryDependencies ++= Seq(
      scalaTest))
lazy val `word-count` = (project in file("word-count")).settings(libraryDependencies ++= Seq(
      scalaTest))
lazy val `wordy` = (project in file("wordy")).settings(libraryDependencies ++= Seq(
      scalaParserCombinators, scalaTest))
lazy val `zebra-puzzle` = (project in file("zebra-puzzle")).settings(libraryDependencies ++= Seq(
      scalaTest))
lazy val `zipper` = (project in file("zipper")).settings(libraryDependencies ++= Seq(
      scalaTest))
