package a;

import java.util.List;
import net.minecraft.client.gui.screen.recipebook.RecipeResultCollection;
import net.minecraft.client.recipebook.ClientRecipeBook;
import net.minecraft.client.search.SearchManager;
import net.minecraft.client.search.SearchProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.RegistryWrapper.WrapperLookup;
import net.minecraft.world.World;

final class ekp extends SearchManager {
   @Override
   public void refresh() {
   }

   @Override
   public void addRecipeOutputReloader(ClientRecipeBook recipeBook, World world) {
   }

   @Override
   public SearchProvider<RecipeResultCollection> getRecipeOutputReloadFuture() {
      return SearchProvider.empty();
   }

   @Override
   public void addItemTagReloader(List<ItemStack> stacks) {
   }

   @Override
   public SearchProvider<ItemStack> getItemTagReloadFuture() {
      return SearchProvider.empty();
   }

   @Override
   public void addItemTooltipReloader(WrapperLookup registries, List<ItemStack> stacks) {
   }

   @Override
   public SearchProvider<ItemStack> getItemTooltipReloadFuture() {
      return SearchProvider.empty();
   }
}
