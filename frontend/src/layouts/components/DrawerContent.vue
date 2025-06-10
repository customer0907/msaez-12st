<script setup>
import {
  VerticalNavLink,
  VerticalNavSectionTitle,
} from '@layouts'
</script>

<template>
    <ul>
        <VerticalNavSectionTitle :item="{ heading: 'Order' }" />
        <VerticalNavLink
            :item="{
                title: 'Order',
                to: '/orders',
            }"
        />
        <VerticalNavSectionTitle :item="{ heading: 'Deliver' }" />
        <VerticalNavLink
            :item="{
                title: 'Deliver',
                to: '/delivers',
            }"
        />
        <VerticalNavSectionTitle :item="{ heading: 'Product' }" />
        <VerticalNavLink
            :item="{
                title: 'Inventory',
                to: '/inventories',
            }"
        />
        <VerticalNavSectionTitle :item="{ heading: 'Dashboard' }" />
        <VerticalNavLink
            :item="{
                title: 'Mypage',
                to: '/mypages',
            }"
        />
    </ul>
</template>
