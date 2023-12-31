package basicmod.cards.skills;

import basicmod.cards.BaseCard;
import basicmod.character.Deathbringer;
import basicmod.util.CardStats;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;

public class Sanctuary extends BaseCard {
    public static final String ID = makeID("Sanctuary");
    private static final CardStats info = new CardStats(
            Deathbringer.Enums.CARD_COLOR,
            CardType.SKILL,
            CardRarity.UNCOMMON,
            CardTarget.SELF,
            -2  // Energy cost set to -2 for unplayable cards
    );

    private static final int DRAW = 2;
    private static final int UPGRADE_PLUS_DRAW = 1;

    public Sanctuary() {
        super(ID, info);
        this.cost = -2;  // Making the card Unplayable
        this.magicNumber = this.baseMagicNumber = DRAW;
    }

    @Override
    public boolean canUse(AbstractPlayer p, AbstractMonster m) {
        this.cantUseMessage = cardStrings.EXTENDED_DESCRIPTION[0];
        return false;
    }

    @Override
    public void use(AbstractPlayer p, AbstractMonster m) {
        // Do nothing because it's unplayable
    }

    public void triggerShadowplayEffect() {
        addToBot(new DrawCardAction(AbstractDungeon.player, this.magicNumber));
    }

    @Override
    public void upgrade() {
        if (!upgraded) {
            upgradeName();
            upgradeMagicNumber(UPGRADE_PLUS_DRAW);
            initializeDescription();
        }
    }

    @Override
    public AbstractCard makeCopy() {
        return new Sanctuary();
    }
}
