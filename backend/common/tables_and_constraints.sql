call create_or_replace_table(
    'ti_account',
    'ti_acco',
    0,
    concat(
        create_varchar_column('access_token', 200, 1, null), ',',
        create_varchar_column('gw_id', 100, 1, null), ',',
        create_varchar_column('name', 60, 1, null), ',',
        create_numeric_column('world', 6, 0, 1, null), ',',
        create_varchar_column('guild1', 100, 0, null), ',',
        create_varchar_column('guild2', 100, 0, null), ',',
        create_varchar_column('guild3', 100, 0, null), ',',
        create_varchar_column('guild4', 100, 0, null), ',',
        create_varchar_column('guild5', 100, 0, null), ',',
        create_datetime_column('created', 1, 0), ',',
        create_varchar_column('access', 60, 0, null), ',',
        create_numeric_column('commander', 1, 0, 0, null), ',',
        create_numeric_column('fractal_level', 3, 0, 0, null), ',',
        create_numeric_column('daily_ap', 6, 0, 0, null), ',',
        create_numeric_column('monthly_ap', 6, 0, 0, null), ',',
        create_numeric_column('wvw_rank', 4, 0, 0, null)
    )
);

call create_or_replace_table (
    'ti_account_achievements',
    'ti_acac',
    0,
    concat(
        create_varchar_column('access_token', 200, 1, null), ',',
        create_numeric_column('gw_id', 6, 0, 1, null), ',',
        create_numeric_column('current', 11, 2, 1, null), ',',
        create_numeric_column('max', 11, 2, 1, null) ,',',
        create_numeric_column('done', 1, 0, 0, null)
        -- bits?
    )
);

call create_or_replace_table (
    'ti_account_bank',
    'ti_acba',
    0,
    concat(
        create_varchar_column('access_token', 200, 1, null), ',',
        create_int_column('gw_id', 0, null), ',',
        create_numeric_column('count', 4, 0, 0, null), ',',
        create_varchar_column('binding', 60, 0, null)
    )
);

call create_or_replace_table (
    'ti_account_dyes',
    'ti_acdy',
    0,
    concat(
        create_varchar_column('access_token', 200, 1, null), ',',
        create_int_column('gw_id', 0, null)
    )
);

call create_or_replace_table (
    'ti_account_inventory',
    'ti_acin',
    0,
    concat(
        create_varchar_column('access_token', 200, 1, null), ',',
        create_int_column('gw_id', 0, null), ',',
        create_numeric_column('count', 4, 0, 0, null), ',',
        create_varchar_column('binding', 60, 0, null)
    )
);

call create_or_replace_table (
    'ti_account_materials',
    'ti_acma',
    0,
    concat(
        create_varchar_column('access_token', 200, 1, null), ',',
        create_int_column('gw_id', 0, null), ',',
        create_numeric_column('category', 3, 0, 0, null), ',',
        create_numeric_column('count', 4, 0 , 0, null)
    )
);

call create_or_replace_table (
    'ti_account_minis',
    'ti_acmi',
    0,
    concat(
        create_varchar_column('access_token', 200, 1, null), ',',
        create_int_column('gw_id', 0, null)
    )
);

call create_or_replace_table (
    'ti_account_outfits',
    'ti_acou',
    0,
    concat(
        create_varchar_column('access_token', 200, 1, null), ',',
        create_int_column('gw_id', 0, null)
    )
);

call create_or_replace_table (
    'ti_account_skins',
    'ti_acsk',
    0,
    concat(
        create_varchar_column('access_token', 200, 1, null), ',',
        create_int_column('gw_id', 0, null)
    )
);

call create_or_replace_table (
    'ti_account_titles',
    'ti_acti',
    0,
    concat(
        create_varchar_column('access_token', 200, 1, null), ',',
        create_int_column('gw_id', 0, null)
    )
);

call create_or_replace_table (
    'ti_account_wallet',
    'ti_acwa',
    0,
    concat(
        create_varchar_column('access_token', 200, 1, null), ',',
        create_int_column('gw_id', 0, null), ',',
        create_numeric_column('value', 9, 0, 0, null)
    )
);

call create_or_replace_table (
    'ti_achievements',
    'ti_achi',
    0,
    concat(
        create_int_column('gw_id', 0, null), ',',
        create_varchar_column('name', 80, 0, null), ',',
        create_varchar_column('description', 1000, 0, null), ',',
        create_varchar_column('requirement', 1000, 0, null), ',',
        create_varchar_column('locked_text', 1000, 0, null), ',',
        create_varchar_column('type', 1000, 0, null)
        -- flags?
        -- tiers?
        -- prerequisites?
        -- rewards?
    )
);

call create_or_replace_table (
    'ti_achievements_flags',
    'ti_acfl',
    0,
    concat(
        create_int_column('ti_achi_id', 0, null), ',',
        create_varchar_column('flag', 20, 0, null)
    )
);

call create_or_replace_table (
    'ti_achievements_tiers',
    'ti_acte',
    0,
    concat(
        create_int_column('ti_achi_id', 0, null), ',',
        create_numeric_column('count', 6, 0, 0, null), ',',
        create_numeric_column('points', 6, 0, 0, null)
    )
);

call create_or_replace_table (
    'ti_achievements_prerequisites',
    'ti_acpr',
    0,
    concat(
        create_int_column('ti_achi_id', 0, null), ',',
        create_numeric_column('prerequisite', 6, 0, 0, null)
    )
);

call create_or_replace_table (
    'ti_achievements_rewards',
    'ti_acre',
    0,
    concat(
        create_int_column('ti_achi_id', 0, null), ',',
        create_varchar_column('type', 60, 0, null), ',',
        create_int_column('gw_id', 0, null), ',',
        create_numeric_column('count', 4, 0, 0, null)
    )
);

call create_or_replace_table (
    'ti_achievement_categories',
    'ti_acca',
    0,
    concat(
        create_int_column('gw_id', 0, null), ',',
        create_varchar_column('name', 100, 0, null), ',',
        create_varchar_column('description', 1000, 0, null), ',',
        create_numeric_column('`order`', 4, 0, 0, null), ',',
        create_varchar_column('icon', 500, 0, null)
    )
);

call create_or_replace_table (
    'ti_achievement_categories_achi',
    'ti_accc',
    0,
    concat(
        create_int_column('ti_acca_id', 0, null), ',',
        create_numeric_column('achievement', 6, 0, 0, null)
    )
);

call create_or_replace_table (
    'ti_daily_achievements',
    'ti_daac',
    0,
    concat(
        create_varchar_column('daac_type', 10, 0, null), ',',
        create_int_column('gw_id', 0, null), ',',
        create_numeric_column('min_level', 3, 0, 0, null), ',',
        create_numeric_column('max_level', 3, 0, 0, null), ',',
        create_varchar_column('required_accesses', 100, 0, null)
    )
);

call create_or_replace_table (
    'ti_tomorrow_daily_achievements',
    'ti_toda',
    0,
    concat(
        create_varchar_column('toda_type', 10, 0, null), ',',
        create_int_column('gw_id', 0, null), ',',
        create_numeric_column('min_level', 3, 0, 0, null), ',',
        create_numeric_column('max_level', 3, 0, 0, null), ',',
        create_varchar_column('required_accesses', 100, 0, null)
    )
);

call create_or_replace_table (
    'ti_achievement_groups',
    'ti_acgr',
    0,
    concat(
        create_varchar_column('gw_id', 200, 0, null), ',',
        create_varchar_column('name', 100, 0, null), ',',
        create_varchar_column('description', 1000, 0, null), ',',
        create_numeric_column('`order`', 3, 0, 0, null)
    )
);

call create_or_replace_table (
    'ti_achievement_groups_cate',
    'ti_acgc',
    0,
    concat(
        create_int_column('ti_acgr_id', 0, null), ',',
        create_numeric_column('category', 6, 0, 0, null)
    )
);

call create_or_replace_table (
    'ti_build',
    'ti_buil',
    0,
    concat(
        create_int_column('gw_id', 0, null)
    )
);

call create_or_replace_table (
    'ti_characters',
    'ti_char',
    0,
    concat(
        create_varchar_column('access_token', 200, 1, null), ',',
        create_varchar_column('name', 100, 1, null), ',',
        create_varchar_column('race', 50, 0, null), ',',
        create_varchar_column('gender', 20, 0, null), ',',
        create_varchar_column('profession', 30, 0, null), ',',
        create_numeric_column('level', 3, 0, 0, null), ',',
        create_varchar_column('guild', 200, 0, null), ',',
        create_numeric_column('age', 9, 0, 0, null), ',',
        create_datetime_column('created', 0, 0), ',',
        create_numeric_column('deaths', 7, 0, 0, null), ',',
        create_numeric_column('title', 6, 0, 0, null)
    )
);

call create_or_replace_table (
    'ti_character_crafting',
    'ti_chcr',
    0,
    concat(
        create_varchar_column('access_token', 200, 1, null), ',',
        create_int_column('ti_char_id', 1, null), ',',
        create_varchar_column('discipline', 50, 0, null), ',',
        create_numeric_column('rating', 6, 0, 0, null), ',',
        create_numeric_column('active', 1, 0, 0, null)
    )
);

call create_or_replace_table (
    'ti_character_equipment',
    'ti_cheq',
    0,
    concat(
        create_varchar_column('access_token', 200, 1, null), ',',
        create_int_column('ti_char_id', 1, null), ',',
        create_int_column('gw_id', 0, null), ',',
        create_varchar_column('slot', 60, 0, null), ',',
        -- infusions?
        -- upgrades?
        create_int_column('skin_gw_id', 0, null), ',',
        create_int_column('stats_gw_id', 0, null), ',',
        create_numeric_column('stats_attributes_power', 4, 0, 0, null), ',',
        create_numeric_column('stats_attributes_precision', 4, 0, 0, null), ',',
        create_numeric_column('stats_attributes_critdamage', 4, 0, 0, null), ',',
        create_numeric_column('stats_attributes_toughness', 4, 0, 0, null), ',',
        create_numeric_column('stats_attributes_vitality', 4, 0, 0, null), ',',
        create_numeric_column('stats_attributes_conditiondmg', 4, 0, 0, null)
    )
);

call create_or_replace_table (
    'ti_character_equipment_infus',
    'ti_chei',
    0,
    concat(
        create_int_column('ti_cheq_id', 0, null), ',',
        create_numeric_column('infusion', 6, 0, 0, null)
    )
);

call create_or_replace_table (
    'ti_character_equipment_upgr',
    'ti_cheu',
    0,
    concat(
        create_int_column('ti_cheq_id', 0, null), ',',
        create_numeric_column('upgrade', 6, 0, 0, null)
    )
);

call create_or_replace_table (
    'ti_character_bags',
    'ti_chba',
    0,
    concat(
        create_varchar_column('access_token', 200, 1, null), ',',
        create_int_column('ti_char_id', 1, null), ',',
        create_int_column('bag_gw_id', 0, null), ',',
        create_numeric_column('bag_size', 2, 0, 0, null)
    )
);

call create_or_replace_table (
    'ti_character_inventory',
    'ti_chin',
    0,
    concat(
        create_varchar_column('access_token', 200, 1, null), ',',
        create_int_column('ti_char_id', 1, null), ',',
        create_int_column('ti_chba_id', 0, null), ',',
        create_int_column('gw_id', 0, null), ',',
        create_numeric_column('count', 4, 0, 0, null), ',',
        create_varchar_column('binding', 30, 0, null), ',',
        create_varchar_column('bound_to', 100, 0, null), ',',
        create_int_column('stats_gw_id', 0, null), ',',
        create_numeric_column('stats_attributes_power', 4, 0, 0, null), ',',
        create_numeric_column('stats_attributes_precision', 4, 0, 0, null), ',',
        create_numeric_column('stats_attributes_critdamage', 4, 0, 0, null), ',',
        create_numeric_column('stats_attributes_toughness', 4, 0, 0, null), ',',
        create_numeric_column('stats_attributes_vitality', 4, 0, 0, null), ',',
        create_numeric_column('stats_attributes_conditiondmg', 4, 0, 0, null)
    )
);

call create_or_replace_table (
    'ti_character_recipes',
    'ti_chre',
    0,
    concat(
        create_varchar_column('access_token', 200, 1, null), ',',
        create_int_column('ti_char_id', 1, null), ',',
        create_numeric_column('recipe', 6, 0, 0, null)
    )
);

call create_or_replace_table (
    'ti_character_specializations',
    'ti_chsp',
    0,
    concat(
        create_varchar_column('access_token', 200, 1, null), ',',
        create_int_column('ti_char_id', 1, null), ',',
        create_varchar_column('spec_type', 10, 0, null), ',',
        create_int_column('gw_id', 0, null), ',',
        create_numeric_column('trait_1', 6, 0, 0, null), ',',
        create_numeric_column('trait_2', 6, 0, 0, null), ',',
        create_numeric_column('trait_3', 6, 0, 0, null)
    )
);

call create_or_replace_table (
    'ti_colors',
    'ti_colo',
    0,
    concat(
        create_int_column('gw_id', 0, null), ',',
        create_varchar_column('name', 60, 0, null), ',',
        create_numeric_column('base_rgb_red', 3, 0, 0, null), ',',
        create_numeric_column('base_rgb_green', 3, 0, 0, null), ',',
        create_numeric_column('base_rgb_blue', 3, 0, 0, null), ',',
        create_numeric_column('item', 6, 0, 0, null), ',',
        create_varchar_column('category1', 20, 0, null), ',',
        create_varchar_column('category2', 20, 0, null), ',',
        create_varchar_column('category3', 20, 0, null), ',',
        create_varchar_column('category4', 20, 0, null), ',',
        create_varchar_column('category5', 20, 0, null), ',',
        create_numeric_column('cloth_brightness', 5, 2, 0, null), ',',
        create_numeric_column('cloth_contrast', 5, 2, 0, null), ',',
        create_numeric_column('cloth_hue', 5, 2, 0, null), ',',
        create_numeric_column('cloth_saturation', 9, 6, 0, null), ',',
        create_numeric_column('cloth_lightness', 9, 6, 0, null), ',',
        create_numeric_column('cloth_rgb_red', 3, 0, 0, null), ',',
        create_numeric_column('cloth_rgb_green', 3, 0, 0, null), ',',
        create_numeric_column('cloth_rgb_blue', 3, 0, 0, null), ',',
        create_numeric_column('leather_brightness', 5, 2, 0, null), ',',
        create_numeric_column('leather_contrast', 5, 2, 0, null), ',',
        create_numeric_column('leather_hue', 5, 2, 0, null), ',',
        create_numeric_column('leather_saturation', 9, 6, 0, null), ',',
        create_numeric_column('leather_lightness', 9, 6, 0, null), ',',
        create_numeric_column('leather_rgb_red', 3, 0, 0, null), ',',
        create_numeric_column('leather_rgb_green', 3, 0, 0, null), ',',
        create_numeric_column('leather_rgb_blue', 3, 0, 0, null), ',',
        create_numeric_column('metal_brightness', 5, 2, 0, null), ',',
        create_numeric_column('metal_contrast', 5, 2, 0, null), ',',
        create_numeric_column('metal_hue', 5, 2, 0, null), ',',
        create_numeric_column('metal_saturation', 9, 6, 0, null), ',',
        create_numeric_column('metal_lightness', 9, 6, 0, null), ',',
        create_numeric_column('metal_rgb_red', 3, 0, 0, null), ',',
        create_numeric_column('metal_rgb_green', 3, 0, 0, null), ',',
        create_numeric_column('metal_rgb_blue', 3, 0, 0, null)
    )
);

call create_or_replace_table (
    'ti_commerce_exchange_coins',
    'ti_coec',
    0,
    concat(
        create_numeric_column('coins_per_gem', 7, 0, 0, null), ',',
        create_numeric_column('quantity', 12, 0, 0, null)
    )
);

call create_or_replace_table (
    'ti_commerce_exchange_gems',
    'ti_coeg',
    0,
    concat(
        create_numeric_column('coins_per_gem', 7, 0, 0, null), ',',
        create_numeric_column('quantity', 12, 0, 0, null)
    )
);

call create_or_replace_table (
    'ti_commerce_listings',
    'ti_coli',
    0,
    concat(
        create_int_column('gw_id', 0, null), ',',
        create_varchar_column('list_type', 10, 0, null), ',',
        create_numeric_column('listings', 4, 0, 0, null), ',',
        create_numeric_column('price', 6, 0, 0, null), ',',
        create_numeric_column('quantity', 6, 0, 0, null)
    )
);

call create_or_replace_table (
    'ti_commerce_prices',
    'ti_copr',
    0,
    concat(
        create_int_column('gw_id', 0, null), ',',
        create_numeric_column('whitelisted', 1, 0, 0, null), ',',
        create_numeric_column('buys_quantity', 6, 0, 0, null), ',',
        create_numeric_column('buys_unit_price', 6, 0, 0, null), ',',
        create_numeric_column('sells_quantity', 6, 0, 0, null), ',',
        create_numeric_column('sells_unit_price', 6, 0, 0, null)
    )
);

call create_or_replace_table (
    'ti_commerce_transactions',
    'ti_cotr',
    0,
    concat(
        create_varchar_column('time', 10, 0, null), ',',
        create_varchar_column('type', 10, 0, null), ',',
        create_int_column('gw_id', 0, null), ',',
        create_int_column('item_gw_id', 0, null) ,',',
        create_numeric_column('price', 6, 0, 0, null), ',',
        create_numeric_column('quantity', 4, 0, 0, null), ',',
        create_datetime_column('created', 0, 0)
    )
);

call create_or_replace_table (
    'ti_continents',
    'ti_cont',
    0,
    concat(
        create_int_column('gw_id', 0, null), ',',
        create_varchar_column('name', 20, 0, null), ',',
        create_numeric_column('continent_dim_x', 6, 0, 0, null), ',',
        create_numeric_column('continent_dim_y', 6, 0, 0, null), ',',
        create_numeric_column('min_zoom', 2, 0, 0, null), ',',
        create_numeric_column('max_zoom', 2, 0, 0, null)
    )
);

call create_or_replace_table (
    'ti_currencies',
    'ti_curr',
    0,
    concat(
        create_int_column('gw_id', 0, null), ',',
        create_varchar_column('name', 60, 0, null), ',',
        create_varchar_column('description', 1000, 0, null), ',',
        create_numeric_column('`order`', 4, 0, 0, null), ',',
        create_varchar_column('icon', 1000, 0, null)
    )
);

call create_or_replace_table (
    'ti_emblem',
    'ti_embl',
    0,
    concat(
        create_int_column('gw_id', 0, null), ',',
        create_varchar_column('layer1', 1000, 0, null), ',',
        create_varchar_column('layer2', 1000, 0, null), ',',
        create_varchar_column('layer3', 1000, 0, null), ',',
        create_varchar_column('layer4', 1000, 0, null), ',',
        create_varchar_column('layer5', 1000, 0, null), ',',
        create_varchar_column('layer6', 1000, 0, null), ',',
        create_varchar_column('layer7', 1000, 0, null), ',',
        create_varchar_column('layer8', 1000, 0, null), ',',
        create_varchar_column('layer9', 1000, 0, null), ',',
        create_varchar_column('layer10', 1000, 0, null)
    )
);

call create_or_replace_table (
    'ti_files',
    'ti_file',
    0,
    concat(
        create_varchar_column('gw_id', 80, 0, null), ',',
        create_varchar_column('icon', 1000, 0, null)
    )
);

call create_or_replace_table (
    'ti_finishers',
    'ti_fini',
    0,
    concat(     
        create_int_column('gw_id', 0, null), ',',
        create_varchar_column('unlock_details', 1000, 0, null), ',',
        create_numeric_column('`order`', 4, 0, 0, null), ',',
        create_varchar_column('icon', 1000, 0, null), ',',
        create_varchar_column('name', 500, 0, null)
    )
);

call create_or_replace_table (
    'ti_items',
    'ti_item',
    0,
    concat(
        create_int_column('gw_id', 0, null), ',',
        create_varchar_column('name', 200, 0, null), ',',
        create_varchar_column('description', 1000, 0, null), ',',
        create_varchar_column('type', 80, 0, null), ',',
        create_numeric_column('level', 3, 0, 0, null), ',',
        create_varchar_column('rarity', 30, 0, null), ',',
        create_numeric_column('vendor_value', 12, 0, 0, null), ',',
        create_int_column('default_skin', 0, null), ',',
        create_varchar_column('game_type1', 80, 0, null), ',',
        create_varchar_column('game_type2', 80, 0, null), ',',
        create_varchar_column('game_type3', 80, 0, null), ',',
        create_varchar_column('game_type4', 80, 0, null), ',',
        create_varchar_column('game_type5', 80, 0, null), ',',
        create_varchar_column('game_type6', 80, 0, null), ',',
        create_varchar_column('game_type7', 80, 0, null), ',',
        create_varchar_column('flag1', 80, 0, null), ',',
        create_varchar_column('flag2', 80, 0, null), ',',
        create_varchar_column('flag3', 80, 0, null), ',',
        create_varchar_column('flag4', 80, 0, null), ',',
        create_varchar_column('flag5', 80, 0, null), ',',
        create_varchar_column('flag6', 80, 0, null), ',',
        create_varchar_column('flag7', 80, 0, null), ',',
        create_varchar_column('restriction1', 80, 0, null), ',',
        create_varchar_column('restriction2', 80, 0, null), ',',
        create_varchar_column('restriction3', 80, 0, null), ',',
        create_varchar_column('restriction4', 80, 0, null), ',',
        create_varchar_column('restriction5', 80, 0, null), ',',
        create_varchar_column('restriction6', 80, 0, null), ',',
        create_varchar_column('restriction7', 80, 0, null), ',',
        create_varchar_column('chat_link', 80, 0, null), ',',
        create_varchar_column('icon', 1000, 0, null), ',',
        create_varchar_column('details_type', 80, 0, null), ',',
        create_varchar_column('details_weight_class', 30, 0, null), ',',
        create_numeric_column('details_defense', 6, 0, 0, null), ',',
        create_int_column('details_suffix_item_id', 0, null), ',',
        create_varchar_column('details_sec_suffix_item_id', 500, 0, null), ',',
        create_int_column('details_infusion_slot1', 0, null), ',',
        create_int_column('details_infusion_slot2', 0, null), ',',
        create_int_column('details_infusion_slot3', 0, null), ',',
        create_int_column('details_infix_upgr_id', 0, null), ',',
        create_varchar_column('details_infix_upgr_att', 80, 0, null), ',',
        create_numeric_column('details_infix_upgr_mod', 6, 0, 0, null)
    )
);

call create_or_replace_table (
    'ti_item_stats',
    'ti_itst',
    0,
    concat(
        create_int_column('gw_id', 0, null), ',',
        create_varchar_column('name', 80, 0, null), ',',
        create_numeric_column('attr_toughness', 8, 2, 0, null), ',',
        create_numeric_column('attr_vitality', 8, 2, 0, null), ',',
        create_numeric_column('attr_power', 8, 2, 0, null), ',',
        create_numeric_column('attr_critdamage', 8, 2, 0, null), ',',
        create_numeric_column('attr_precision', 8, 2, 0, null), ',',
        create_numeric_column('attr_conditiondmg', 8, 2, 0, null)
    )
);

call create_or_replace_table (
    'ti_legends',
    'ti_lege',
    0,
    concat(
        create_varchar_column('gw_id', 30, 0, null), ',',
        create_numeric_column('swap', 6, 0, 0, null), ',',
        create_numeric_column('heal', 6, 0, 0, null), ',',
        create_numeric_column('elite', 6, 0, 0, null), ',',
        create_numeric_column('utility1', 6, 0, 0, null), ',',
        create_numeric_column('utility2', 6, 0, 0, null), ',',
        create_numeric_column('utility3', 6, 0, 0, null), ',',
        create_numeric_column('utility4', 6, 0, 0, null), ',',
        create_numeric_column('utility5', 6, 0, 0, null), ',',
        create_numeric_column('utility6', 6, 0, 0, null), ',',
        create_numeric_column('utility7', 6, 0, 0, null)
    )
);

call create_or_replace_table (
    'ti_maps',
    'ti_maps',
    0,
    concat(
        create_int_column('gw_id', 0, null), ',',
        create_varchar_column('name', 100, 0, null), ',',
        create_numeric_column('min_level', 3, 0, 0, null), ',',
        create_numeric_column('max_level', 3, 0, 0, null), ',',
        create_numeric_column('default_floor', 2, 0, 0, null), ',',
        create_int_column('region_id', 0, null), ',',
        create_varchar_column('region_name', 100, 0, null), ',',
        create_int_column('continent_id', 0, null), ',',
        create_varchar_column('continent_name', 80, 0, null)
    )
);
