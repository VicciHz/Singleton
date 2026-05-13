Detta är en exempelapplikation för designmönstret **singleton** 
___
# Singleton (Singelton)

## Introduktion

Singleton är ett **skapande mönster** som säkerställer att en klass endast har **en instans** och tillhandahåller en global åtkomstpunkt till den.

---

## Problem

Singleton-mönstret löser två problem samtidigt (vilket tekniskt sett bryter mot *Single Responsibility Principle*):

1. **En enda instans** — Viss kod kräver exakt en instans av en klass, t.ex. en databasanslutning eller ett konfigurationsobjekt. Skapar du flera instanser riskerar du race conditions, inkonsekvent data och onödig resursåtgång.
2. **Global åtkomst** — Objektet ska vara åtkomligt från var som helst i programmet, men skyddad från att skrivas över av misstag.

## Lösning

Alla Singleton-implementationer delar dessa två egenskaper:

- **Privat konstruktor** — Förhindrar att andra klasser skapar instanser med `new`.
- **Statisk åtkomstmetod** — En metod som skapar instansen vid första anropet och returnerar den cachade instansen vid alla efterföljande anrop.

## När ska Singleton användas?

- När en klass i ditt program bara ska ha en enda instans för alla klienter.
- T.ex. delad databasanslutning, logg-system, konfigurationshanterare, connection pool.

## Struktur

| Del                         | Beskrivning                                              |
| --------------------------- | -------------------------------------------------------- |
| **Privat konstruktor**      | Hindrar direkt instansiering.                            |
| **Statiskt privat fält**    | Lagrar den enda instansen.                               |
| **Statisk `getInstance()`** | Skapar (lazy) eller returnerar den befintliga instansen. |

---

## Exempel — Databasanslutning (Java)

Scenariot: En databasklass som garanterar att bara en anslutning skapas, även i flertrådade miljöer.