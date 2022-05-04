package ru.allebedev.core

import java.time.Instant

case class DataForStamp(text:String, stamp: Option[Instant] = None)
