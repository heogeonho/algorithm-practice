-- 아이템의 희귀도가 'RARE'인 아이템들의 모든 다음 업그레이드 아이템의 아이템
-- 결과는 아이템 ID를 기준으로 내림차순 정렬
SELECT c.ITEM_ID, c.ITEM_NAME, c.RARITY
FROM ITEM_TREE t
JOIN ITEM_INFO p
ON p.ITEM_ID = t.PARENT_ITEM_ID
JOIN ITEM_INFO c
ON c.ITEM_ID = t.ITEM_ID
WHERE p.RARITY = 'RARE'
ORDER BY c.ITEM_ID DESC