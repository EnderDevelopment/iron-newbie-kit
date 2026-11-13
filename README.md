# Minecraft Starter Kit Plugin

Iron Newbie Kit is a Minecraft Paper plugin that automatically gives first-time players an enhanced iron starter kit when they join the server. This Minecraft plugin includes iron armor, enchanted iron tools, a starter kit listener, and first-join detection for Paper 1.21 servers.

## Install

1. Build the plugin with Java 21 and Maven:

   `mvn package`

2. Copy the generated `target/plugin.jar` file to your server's `plugins` directory.

3. Start or restart a Paper Minecraft server running version 1.21 or newer.

4. Confirm that the plugin loads successfully in the server console.

## Use

1. Have a new player join the server for the first time.
2. The plugin gives the player the starter kit in their inventory.
3. The player receives:

   - Enhanced iron sword with Sharpness II and Unbreaking II
   - Enhanced iron pickaxe with Efficiency II and Unbreaking II
   - Enhanced iron axe with Efficiency II and Unbreaking II
   - Enhanced iron shovel with Efficiency II and Unbreaking II
   - Reinforced iron helmet with Protection II and Unbreaking II
   - Reinforced iron chestplate with Protection II and Unbreaking II
   - Reinforced iron leggings with Protection II and Unbreaking II
   - Reinforced iron boots with Protection II and Unbreaking II

4. The player receives an in-game message confirming that the kit was given.

The kit is only granted when the player joins for the first time. The plugin has no commands, configuration file, or permission requirements.

---

More Minecraft plugin projects by EnderDevelopment: https://github.com/EnderDevelopment

Project page: https://dash.enderdevelopment.com/community/0cb5fe7d-e5bf-4a66-9ace-6f4cdca236f1?utm_source=github&utm_medium=readme&utm_campaign=auto_publish&utm_content=0cb5fe7d-e5bf-4a66-9ace-6f4cdca236f1
