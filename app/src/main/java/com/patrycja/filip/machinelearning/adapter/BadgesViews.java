package com.patrycja.filip.machinelearning.adapter;

import com.patrycja.filip.machinelearning.R;
import com.patrycja.filip.machinelearning.adapter.model.BadgeItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zwsfke on 2017-12-09.
 */

public class BadgesViews {

    public static final List<BadgeItem> getBadges() {
        ArrayList<BadgeItem> items = new ArrayList<>();
        for (int id : ids) {
            items.add(new BadgeItem(id, badgesText.get(id), badges.get(id)));
        }
        return items;
    }

    private static final List<Integer> ids = new ArrayList<Integer>() {{
        add(0);
        add(1);
        add(2);
        add(3);
        add(4);
        add(5);
        add(6);
        add(7);
        add(8);
        add(9);
        add(10);
        add(11);
        add(12);
        add(13);
        add(14);
        add(15);
        add(16);
        add(17);
        add(18);
        add(19);
        add(20);
        add(21);
    }};

    private static final List<Integer> badges = new ArrayList<Integer>() {{
        add(R.drawable.badge_1);
        add(R.drawable.badge_2);
        add(R.drawable.crown_1);
        add(R.drawable.crown);
        add(R.drawable.diploma);
        add(R.drawable.file);
        add(R.drawable.gold_medal);
        add(R.drawable.medal_15);
        add(R.drawable.medal_19);
        add(R.drawable.medal_2);
        add(R.drawable.medal_34);
        add(R.drawable.medal_35);
        add(R.drawable.medal_40);
        add(R.drawable.medal_45);
        add(R.drawable.medal_46);
        add(R.drawable.medal_47);
        add(R.drawable.shield_4);
        add(R.drawable.trophy_11);
        add(R.drawable.trophy_16);
        add(R.drawable.trophy_19);
        add(R.drawable.trophy_21);
        add(R.drawable.trophy_5);
    }};

    private static final List<String> badgesText = new ArrayList<String>() {{
        add("First Play!");
        add("First Launch of App!");
        add("Rated in Google Play!");
        add("Reached 3. chapter!");
        add("Reached 5. chapter!");
        add("Reached 7. chapter!");
        add("Upcoming Badge");
        add("Upcoming Badge");
        add("Upcoming Badge");
        add("Upcoming Badge");
        add("Upcoming Badge");
        add("Upcoming Badge");
        add("Upcoming Badge");
        add("Upcoming Badge");
        add("Upcoming Badge");
        add("Upcoming Badge");
        add("Upcoming Badge");
        add("Upcoming Badge");
        add("Upcoming Badge");
        add("Upcoming Badge");
        add("Upcoming Badge");
        add("Upcoming Badge");
    }};

}
