package client

import caliban.client.CalibanClientError.DecodingError
import caliban.client.FieldBuilder._
import caliban.client._
import caliban.client.__Value._

object ClientSchema {

  sealed trait Episode extends scala.Product with scala.Serializable {
    def value: String
  }
  object Episode {
    case object NEWHOPE extends Episode { val value: String = "NEWHOPE" }
    case object EMPIRE  extends Episode { val value: String = "EMPIRE"  }
    case object JEDI    extends Episode { val value: String = "JEDI"    }
    case object jedi_1  extends Episode { val value: String = "jedi_1"  }

    implicit val decoder: ScalarDecoder[Episode] = {
      case __StringValue("NEWHOPE") => Right(Episode.NEWHOPE)
      case __StringValue("EMPIRE")  => Right(Episode.EMPIRE)
      case __StringValue("JEDI")    => Right(Episode.JEDI)
      case __StringValue("jedi")    => Right(Episode.jedi_1)
      case other =>
        Left(DecodingError(s"Can't build Episode from input $other"))
    }
    implicit val encoder: ArgEncoder[Episode] = {
      case Episode.NEWHOPE => __EnumValue("NEWHOPE")
      case Episode.EMPIRE  => __EnumValue("EMPIRE")
      case Episode.JEDI    => __EnumValue("JEDI")
      case Episode.jedi_1  => __EnumValue("jedi")
    }

    val values: scala.collection.immutable.Vector[Episode] =
      scala.collection.immutable.Vector(NEWHOPE, EMPIRE, JEDI, jedi_1)
  }

  type Character
  object Character {
    def name: SelectionBuilder[Character, String] =
      _root_.caliban.client.SelectionBuilder.Field("name", Scalar())
  }

  type character_1
  object character_1 {
    def name: SelectionBuilder[character_1, String] =
      _root_.caliban.client.SelectionBuilder.Field("name", Scalar())
  }

  type Human
  object Human {
    def name: SelectionBuilder[Human, String] =
      _root_.caliban.client.SelectionBuilder.Field("name", Scalar())
  }

  type human_1
  object human_1 {
    def name: SelectionBuilder[human_1, String] =
      _root_.caliban.client.SelectionBuilder.Field("name", Scalar())
  }

  type humaN_2
  object humaN_2 {
    def name: SelectionBuilder[humaN_2, String] =
      _root_.caliban.client.SelectionBuilder.Field("name", Scalar())
  }

  type Droid
  object Droid {
    def name[A](
        innerSelection: SelectionBuilder[Human, A]
    ): SelectionBuilder[Droid, A] =
      _root_.caliban.client.SelectionBuilder.Field("name", Obj(innerSelection))
  }

  type Starship
  object Starship {
    def name[A](
        innerSelection: SelectionBuilder[human_1, A]
    ): SelectionBuilder[Starship, A] =
      _root_.caliban.client.SelectionBuilder.Field("name", Obj(innerSelection))
  }

  final case class MessageInput(
      content: scala.Option[String] = None,
      author: scala.Option[String] = None
  )
  object MessageInput {
    implicit val encoder: ArgEncoder[MessageInput] =
      new ArgEncoder[MessageInput] {
        override def encode(value: MessageInput): __Value =
          __ObjectValue(
            List(
              "content" -> value.content.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              ),
              "author" -> value.author.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              )
            )
          )
      }
  }
  final case class messageInput_1(
      content: scala.Option[String] = None,
      author: scala.Option[String] = None
  )
  object messageInput_1 {
    implicit val encoder: ArgEncoder[messageInput_1] =
      new ArgEncoder[messageInput_1] {
        override def encode(value: messageInput_1): __Value =
          __ObjectValue(
            List(
              "content" -> value.content.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              ),
              "author" -> value.author.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              )
            )
          )
      }
  }
  final case class MessageInpuT_2(
      content: scala.Option[String] = None,
      author: scala.Option[String] = None
  )
  object MessageInpuT_2 {
    implicit val encoder: ArgEncoder[MessageInpuT_2] =
      new ArgEncoder[MessageInpuT_2] {
        override def encode(value: MessageInpuT_2): __Value =
          __ObjectValue(
            List(
              "content" -> value.content.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              ),
              "author" -> value.author.fold(__NullValue: __Value)(value =>
                implicitly[ArgEncoder[String]].encode(value)
              )
            )
          )
      }
  }
  type Query = _root_.caliban.client.Operations.RootQuery
  object Query {
    def episode[A](
        tpe: scala.Option[Episode] = None
    )(innerSelection: SelectionBuilder[human_1, A])(implicit
        encoder0: ArgEncoder[scala.Option[Episode]]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "episode",
        Obj(innerSelection),
        arguments = List(Argument("tpe", tpe, "Episode")(encoder0))
      )
    def episode2[A](tpe: scala.Option[Episode] = None)(
        innerSelection: SelectionBuilder[Human, A]
    )(implicit encoder0: ArgEncoder[scala.Option[Episode]]): SelectionBuilder[
      _root_.caliban.client.Operations.RootQuery,
      scala.Option[A]
    ] = _root_.caliban.client.SelectionBuilder.Field(
      "episode2",
      OptionOf(Obj(innerSelection)),
      arguments = List(Argument("tpe", tpe, "Episode")(encoder0))
    )
    def episode3[A](tpe: scala.Option[Episode] = None)(
        innerSelection: SelectionBuilder[humaN_2, A]
    )(implicit encoder0: ArgEncoder[scala.Option[Episode]]): SelectionBuilder[
      _root_.caliban.client.Operations.RootQuery,
      scala.Option[A]
    ] = _root_.caliban.client.SelectionBuilder.Field(
      "episode3",
      OptionOf(Obj(innerSelection)),
      arguments = List(Argument("tpe", tpe, "Episode")(encoder0))
    )
    def episode4[A](
        tpe: scala.Option[Episode] = None
    )(onHuman: SelectionBuilder[Human, A])(implicit
        encoder0: ArgEncoder[scala.Option[Episode]]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "episode4",
        ChoiceOf(Map("Human" -> Obj(onHuman))),
        arguments = List(Argument("tpe", tpe, "Episode")(encoder0))
      )
    def episode4Option[A](tpe: scala.Option[Episode] = None)(
        onHuman: scala.Option[SelectionBuilder[Human, A]] = None
    )(implicit encoder0: ArgEncoder[scala.Option[Episode]]): SelectionBuilder[
      _root_.caliban.client.Operations.RootQuery,
      scala.Option[A]
    ] = _root_.caliban.client.SelectionBuilder.Field(
      "episode4",
      ChoiceOf(
        Map(
          "Human" -> onHuman.fold[FieldBuilder[scala.Option[A]]](NullField)(a =>
            OptionOf(Obj(a))
          )
        )
      ),
      arguments = List(Argument("tpe", tpe, "Episode")(encoder0))
    )
    def episode5[A](tpe: scala.Option[Episode] = None)(
        onhumaN: SelectionBuilder[humaN_2, A],
        onhuman: SelectionBuilder[human_1, A]
    )(implicit
        encoder0: ArgEncoder[scala.Option[Episode]]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "episode5",
        ChoiceOf(Map("humaN" -> Obj(onhumaN), "human" -> Obj(onhuman))),
        arguments = List(Argument("tpe", tpe, "Episode")(encoder0))
      )
    def episode5Option[A](tpe: scala.Option[Episode] = None)(
        onhumaN: scala.Option[SelectionBuilder[humaN_2, A]] = None,
        onhuman: scala.Option[SelectionBuilder[human_1, A]] = None
    )(implicit encoder0: ArgEncoder[scala.Option[Episode]]): SelectionBuilder[
      _root_.caliban.client.Operations.RootQuery,
      scala.Option[A]
    ] = _root_.caliban.client.SelectionBuilder.Field(
      "episode5",
      ChoiceOf(
        Map(
          "humaN" -> onhumaN.fold[FieldBuilder[scala.Option[A]]](NullField)(a =>
            OptionOf(Obj(a))
          ),
          "human" -> onhuman.fold[FieldBuilder[scala.Option[A]]](NullField)(a =>
            OptionOf(Obj(a))
          )
        )
      ),
      arguments = List(Argument("tpe", tpe, "Episode")(encoder0))
    )
    def episode6[A](tpe: scala.Option[Episode] = None)(
        onHuman: SelectionBuilder[Human, A],
        onhuman: SelectionBuilder[human_1, A]
    )(implicit
        encoder0: ArgEncoder[scala.Option[Episode]]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "episode6",
        ChoiceOf(Map("Human" -> Obj(onHuman), "human" -> Obj(onhuman))),
        arguments = List(Argument("tpe", tpe, "Episode")(encoder0))
      )
    def episode7[A](tpe: scala.Option[Episode] = None)(
        onHuman: SelectionBuilder[Human, A],
        onhuman: SelectionBuilder[human_1, A]
    )(implicit
        encoder0: ArgEncoder[scala.Option[Episode]]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootQuery, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "episode7",
        ChoiceOf(Map("Human" -> Obj(onHuman), "human" -> Obj(onhuman))),
        arguments = List(Argument("tpe", tpe, "Episode")(encoder0))
      )
  }

  type Mutation = _root_.caliban.client.Operations.RootMutation
  object Mutation {
    def createMessage(input: scala.Option[messageInput_1] = None)(implicit
        encoder0: ArgEncoder[scala.Option[messageInput_1]]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, String] =
      _root_.caliban.client.SelectionBuilder.Field(
        "createMessage",
        Scalar(),
        arguments = List(Argument("input", input, "messageInput")(encoder0))
      )
    def createMessage2[A](
        input: scala.Option[messageInput_1] = None
    )(innerSelection: SelectionBuilder[human_1, A])(implicit
        encoder0: ArgEncoder[scala.Option[messageInput_1]]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "createMessage2",
        Obj(innerSelection),
        arguments = List(Argument("input", input, "messageInput")(encoder0))
      )
    def createMessage3[A](
        input: scala.Option[messageInput_1] = None
    )(innerSelection: SelectionBuilder[Human, A])(implicit
        encoder0: ArgEncoder[scala.Option[messageInput_1]]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "createMessage3",
        Obj(innerSelection),
        arguments = List(Argument("input", input, "messageInput")(encoder0))
      )
    def createMessage4[A](
        input: scala.Option[MessageInpuT_2] = None
    )(innerSelection: SelectionBuilder[humaN_2, A])(implicit
        encoder0: ArgEncoder[scala.Option[MessageInpuT_2]]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "createMessage4",
        Obj(innerSelection),
        arguments = List(Argument("input", input, "MessageInpuT")(encoder0))
      )
    def createMessage5[A](
        input: scala.Option[MessageInpuT_2] = None
    )(onHuman: SelectionBuilder[Human, A])(implicit
        encoder0: ArgEncoder[scala.Option[MessageInpuT_2]]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "createMessage5",
        ChoiceOf(Map("Human" -> Obj(onHuman))),
        arguments = List(Argument("input", input, "MessageInpuT")(encoder0))
      )
    def createMessage5Option[A](
        input: scala.Option[MessageInpuT_2] = None
    )(onHuman: scala.Option[SelectionBuilder[Human, A]] = None)(implicit
        encoder0: ArgEncoder[scala.Option[MessageInpuT_2]]
    ): SelectionBuilder[
      _root_.caliban.client.Operations.RootMutation,
      scala.Option[A]
    ] = _root_.caliban.client.SelectionBuilder.Field(
      "createMessage5",
      ChoiceOf(
        Map(
          "Human" -> onHuman.fold[FieldBuilder[scala.Option[A]]](NullField)(a =>
            OptionOf(Obj(a))
          )
        )
      ),
      arguments = List(Argument("input", input, "MessageInpuT")(encoder0))
    )
    def createMessage6[A](input: scala.Option[MessageInpuT_2] = None)(
        onhumaN: SelectionBuilder[humaN_2, A],
        onhuman: SelectionBuilder[human_1, A]
    )(implicit
        encoder0: ArgEncoder[scala.Option[MessageInpuT_2]]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "createMessage6",
        ChoiceOf(Map("humaN" -> Obj(onhumaN), "human" -> Obj(onhuman))),
        arguments = List(Argument("input", input, "MessageInpuT")(encoder0))
      )
    def createMessage6Option[A](input: scala.Option[MessageInpuT_2] = None)(
        onhumaN: scala.Option[SelectionBuilder[humaN_2, A]] = None,
        onhuman: scala.Option[SelectionBuilder[human_1, A]] = None
    )(implicit
        encoder0: ArgEncoder[scala.Option[MessageInpuT_2]]
    ): SelectionBuilder[
      _root_.caliban.client.Operations.RootMutation,
      scala.Option[A]
    ] = _root_.caliban.client.SelectionBuilder.Field(
      "createMessage6",
      ChoiceOf(
        Map(
          "humaN" -> onhumaN.fold[FieldBuilder[scala.Option[A]]](NullField)(a =>
            OptionOf(Obj(a))
          ),
          "human" -> onhuman.fold[FieldBuilder[scala.Option[A]]](NullField)(a =>
            OptionOf(Obj(a))
          )
        )
      ),
      arguments = List(Argument("input", input, "MessageInpuT")(encoder0))
    )
    def createMessage7[A](input: scala.Option[MessageInpuT_2] = None)(
        onHuman: SelectionBuilder[Human, A],
        onhuman: SelectionBuilder[human_1, A]
    )(implicit
        encoder0: ArgEncoder[scala.Option[MessageInpuT_2]]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "createMessage7",
        ChoiceOf(Map("Human" -> Obj(onHuman), "human" -> Obj(onhuman))),
        arguments = List(Argument("input", input, "MessageInpuT")(encoder0))
      )
    def createMessage8[A](input: scala.Option[MessageInpuT_2] = None)(
        onHuman: SelectionBuilder[Human, A],
        onhuman: SelectionBuilder[human_1, A]
    )(implicit
        encoder0: ArgEncoder[scala.Option[MessageInpuT_2]]
    ): SelectionBuilder[_root_.caliban.client.Operations.RootMutation, A] =
      _root_.caliban.client.SelectionBuilder.Field(
        "createMessage8",
        ChoiceOf(Map("Human" -> Obj(onHuman), "human" -> Obj(onhuman))),
        arguments = List(Argument("input", input, "MessageInpuT")(encoder0))
      )
  }

}

